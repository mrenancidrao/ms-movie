package com.ioasys.msmovie.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.msmovie.entities.Movie;
import com.ioasys.msmovie.repositories.MovieRepository;

@RestController
@RequestMapping(value = "/api")
public class MovieResource {
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/movies")
	public List<Movie> listMovies() {
		return movieRepository.findAll();
	}
}
