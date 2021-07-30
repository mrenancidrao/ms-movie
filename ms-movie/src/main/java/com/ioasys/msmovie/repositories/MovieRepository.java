package com.ioasys.msmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ioasys.msmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
