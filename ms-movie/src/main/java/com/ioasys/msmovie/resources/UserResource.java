package com.ioasys.msmovie.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.entities.User;
import com.ioasys.msmovie.repositories.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
@Api(value="API Users")
@CrossOrigin(origins = "*")
public class UserResource {
	
	UserRepository repository;
	
	public UserResource(UserRepository repository) {
		super();
		this.repository = repository;
	}


	@GetMapping
	@ApiOperation(value = "Retorna lista completa de usuários")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um usuário específico conforme id informado")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo usuário")
	public ResponseEntity<User> save(@RequestBody User user) {
		User obj = repository.save(user);
		return ResponseEntity.ok(obj);
	}
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um usuário passando os dados em JSON")
	public ResponseEntity<User> update(@RequestBody User user) {
		User obj = repository.save(user);
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
}
