package com.ioasys.msmovie.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.dto.MovieDto;
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
	public ResponseEntity<Page<Movie>> findAll(Pageable pageable) {
		Page<Movie> list = repository.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/filter")
	@ApiOperation(value = "Retorna lista de filmes com opções de filtros por nome, diretor, gênero e atores.")
	public ResponseEntity<Page<Movie>> findMovies(@RequestBody MovieDto filtro, @PageableDefault(sort = "name", direction = Direction.ASC) Pageable pageable) {
		Page<Movie> list = repository.findMovies(filtro, pageable);
		return ResponseEntity.ok(list);
	}
	
//	@PostMapping(value = "/filter/orderByRating")
//	@ApiOperation(value = "Retorna lista filmes com opções de filtros por nome, diretor, gênero e atores. Ordenado por média de voto/avaliação.")
//	public ResponseEntity<Page<Movie>> findMoviesOrderByRating(@RequestBody MovieDto filtro, @PageableDefault(sort = "averageRating", direction = Direction.DESC) Pageable pageable) {
//		Page<Movie> list = repository.findMovies(filtro, pageable);
//		return ResponseEntity.ok(list);
//	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um filme específico conforme id informado")
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
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um filme passando os dados em JSON")
	public ResponseEntity<Movie> update(@RequestBody Movie movie) {
		Movie obj = repository.save(movie);
		return ResponseEntity.ok(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deleta um filme conforme id informado")
	public void delete(@PathVariable Long id) {
		Movie obj = repository.findById(id).get();
		repository.delete(obj);
	}
}
