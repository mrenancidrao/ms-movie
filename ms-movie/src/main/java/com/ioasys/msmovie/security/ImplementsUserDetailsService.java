package com.ioasys.msmovie.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ioasys.msmovie.entities.User;
import com.ioasys.msmovie.repositories.UserRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	public ImplementsUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findUserByEmail(email); 
		
		if (user==null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return user;
	}
}
