package com.ioasys.msmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ioasys.msmovie.entities.MovieRating;

public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {
	
}
