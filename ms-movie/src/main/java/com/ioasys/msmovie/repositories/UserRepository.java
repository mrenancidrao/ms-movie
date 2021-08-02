package com.ioasys.msmovie.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ioasys.msmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmail(String email);
	
	@Query("select distinct u from User u "
			+ "	join u.roles r "
			+ "where u.active=true and r.name!='ADMIN'"
			)
	Page<User> findAllUsers(Pageable pageable);
	
}
