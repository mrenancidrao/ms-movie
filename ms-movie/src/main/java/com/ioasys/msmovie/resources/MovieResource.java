package com.ioasys.msmovie.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.entities.Movie;
import com.ioasys.msmovie.repositories.MovieRepository;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	MovieRepository repository;
	
	public MovieResource(MovieRepository repository) {
		super();
		this.repository = repository;
	}


	@GetMapping
	public ResponseEntity<List<Movie>> findAll() {
		List<Movie> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id) {
		Movie obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Movie> save(@RequestBody Movie movie) {
		Movie obj = repository.save(movie);
		return ResponseEntity.ok(obj);
	}
}
