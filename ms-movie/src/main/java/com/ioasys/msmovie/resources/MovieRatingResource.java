package com.ioasys.msmovie.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.entities.MovieRating;
import com.ioasys.msmovie.repositories.MovieRatingRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/ratings")
@Api(value="API MovieRatings")
@CrossOrigin(origins = "*")
public class MovieRatingResource {
	
	MovieRatingRepository repository;
	
	public MovieRatingResource(MovieRatingRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna lista completa de avaliações/votos")
	public ResponseEntity<List<MovieRating>> findAll() {
		List<MovieRating> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@PostMapping()
	@ApiOperation(value = "Salva uma nova avaliação/voto recebendo JSON com informações de filme, avaliação/voto e usuário que está votando")
	@PreAuthorize("hasAnyAuthority('USER')")
	public ResponseEntity<MovieRating> save(@RequestBody MovieRating movieRating) {
		MovieRating obj = repository.save(movieRating);
		return ResponseEntity.ok(obj);
	}
}
