package com.ioasys.msmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ioasys.msmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
