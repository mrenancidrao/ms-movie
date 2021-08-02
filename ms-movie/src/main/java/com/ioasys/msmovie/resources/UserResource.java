package com.ioasys.msmovie.resources;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.dto.UserAuthenticateDto;
import com.ioasys.msmovie.dto.UserDto;
import com.ioasys.msmovie.entities.User;
import com.ioasys.msmovie.enums.RoleEnum;
import com.ioasys.msmovie.repositories.RoleRepository;
import com.ioasys.msmovie.repositories.UserRepository;
import com.ioasys.msmovie.security.JwtTokenProvider;
import com.ioasys.msmovie.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
@Api(value="API Users")
@CrossOrigin(origins = "*")
public class UserResource {
	
	private UserRepository repository;
	private RoleRepository roleRepository;
	private UserService userService;
	private JwtTokenProvider jwtTokenProvider;
	
	public UserResource(UserRepository repository, RoleRepository roleRepository, UserService userService) {
		super();
		this.repository = repository;
		this.roleRepository = roleRepository;
		this.userService = userService;
	}


	@GetMapping
	@ApiOperation(value = "Retorna lista de usuários não administradores ativos")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<Page<User>> findAllUsers(@PageableDefault(sort = "name") Pageable pageable) {
		Page<User> list = repository.findAllUsers(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/all")
	@ApiOperation(value = "Retorna lista completa de usuários")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = repository.findAll(Sort.by("name"));
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/search")
	@ApiOperation(value = "Retorna um usuário específico conforme email informado")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = repository.findUserByEmail(email);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo usuário")
	public ResponseEntity<UserAuthenticateDto> save(@RequestBody User user) {
		
		User obj = userService.save(user);
		return ResponseEntity.ok(UserAuthenticateDto.toDto(obj, "Bearer "));
	}
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um usuário passando os dados em JSON")
	public ResponseEntity<User> update(@RequestBody User user) {
		User obj = repository.save(user);
		user.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getRoles()));
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping(value = "/disable/{id}")
	@ApiOperation(value = "Desativa um usuário conforme id informado")
	public ResponseEntity<User> disable(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		obj.setActive(false);
		obj = repository.save(obj);
		
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping(value = "/enable/{id}")
	@ApiOperation(value = "Ativa um usuário conforme id informado")
	public ResponseEntity<User> enable(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		obj.setActive(true);
		obj = repository.save(obj);
		
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping(value = "/turnAdmin/{id}")
	@ApiOperation(value = "Inclui permissão de administrador a um usuário conforme id informado")
	public ResponseEntity<User> turnAdmin(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		obj.getRoles().add(roleRepository.findById(Long.valueOf(RoleEnum.ADMIN.getId())).get());
		obj = repository.save(obj);

		return ResponseEntity.ok(obj);
	}
	
	@PostMapping(value = "/turnOffAdmin/{id}")
	@ApiOperation(value = "Remove permissão de administrador de um usuário conforme id informado")
	public ResponseEntity<User> turnOffAdmin(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		obj.getRoles().removeIf(e -> e.getName().equalsIgnoreCase(RoleEnum.ADMIN.getName()));
		obj = repository.save(obj);

		return ResponseEntity.ok(obj);
	}
	
	@PostMapping(value = "/login")
	@ApiOperation(value = "Efetua login informando email e password")
	public ResponseEntity<UserAuthenticateDto> login(@RequestBody UserDto userDto) {
		User user = userService.login(userDto.getEmail(), userDto.getPassword());
		return ResponseEntity.ok(UserAuthenticateDto.toDto(user, "Bearer "));
	}
}
