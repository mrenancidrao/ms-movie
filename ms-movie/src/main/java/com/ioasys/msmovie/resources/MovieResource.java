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

import com.ioasys.msmovie.entities.Movie;
import com.ioasys.msmovie.repositories.MovieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/movies")
@Api(value="API Movies")
@CrossOrigin(origins = "*")
public class MovieResource {
	
	MovieRepository repository;
	
	public MovieResource(MovieRepository repository) {
		super();
		this.repository = repository;
	}


	@GetMapping
	@ApiOperation(value = "Retorna lista completa de filmes")
	public ResponseEntity<List<Movie>> findAll() {
		List<Movie> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um filme específico")
	public ResponseEntity<Movie> findById(@PathVariable Long id) {
		Movie obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping()
	@ApiOperation(value = "Salva um novo filme")
	public ResponseEntity<Movie> save(@RequestBody Movie movie) {
		Movie obj = repository.save(movie);
		return ResponseEntity.ok(obj);
	}
	
	@DeleteMapping()
	@ApiOperation(value = "Deleta um filme")
	public void delete(@RequestBody Movie movie) {
		repository.delete(movie);
	}
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um filme")
	public ResponseEntity<Movie> update(@RequestBody Movie movie) {
		Movie obj = repository.save(movie);
		return ResponseEntity.ok(obj);
	}
}
