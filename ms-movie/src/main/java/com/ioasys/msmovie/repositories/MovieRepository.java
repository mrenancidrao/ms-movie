package com.ioasys.msmovie.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ioasys.msmovie.dto.MovieDto;
import com.ioasys.msmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findMovieByName(String name);
	
	@Query("select distinct m from Movie m "
			+ "	join m.director d "
			+ "	join m.genre g "
			+ "	join m.actors a "
			+ "where 1=1 "
			+ " and (:#{#filter.name} is null or m.name like '%' || :#{#filter.name ?: ''} || '%')"
			+ " and (:#{#filter.director} is null or d.name like '%' || :#{#filter.director ?: ''} || '%')"
			+ " and (:#{#filter.genre} is null or g.name like '%' || :#{#filter.genre ?: ''} || '%')"
			+ " and (:#{#filter.actor} is null or a.name like '%' || :#{#filter.actor ?: ''} || '%')"
			)
	Page<Movie> findMovies(@Param("filter") MovieDto filter, Pageable pageable);
}
