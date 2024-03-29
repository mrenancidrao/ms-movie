package com.ioasys.msmovie.service;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ioasys.msmovie.entities.User;
import com.ioasys.msmovie.error.handler.CustomException;
import com.ioasys.msmovie.repositories.UserRepository;
import com.ioasys.msmovie.security.JwtTokenProvider;

import io.jsonwebtoken.Claims;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private JwtTokenProvider jwtTokenProvider;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public User save(User user) throws UsernameNotFoundException {
		String passEncrypt = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(passEncrypt);
		return userRepository.save(user);
	}
	
	@Override
	public User login(String email, String password) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(email);
		if (user==null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		if (user.getPassword().equals(bCryptPasswordEncoder.encode(password))) {
			String tokenGenerated= jwtTokenProvider.createToken(email, user.getRoles());
			user.setToken(tokenGenerated);
			return user;
		} else {
			throw new CustomException("Senha inválida", HttpStatus.METHOD_NOT_ALLOWED);
		}
	}

	private boolean validate(String token) {
		try {
			String tokenProcessed = token.replace("Bearer ", "");
			Claims claims = jwtTokenProvider.decodeToken(tokenProcessed);
			System.out.println(claims.getIssuer());
			System.out.println(claims.getIssuedAt());
			
			if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new RuntimeException();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
