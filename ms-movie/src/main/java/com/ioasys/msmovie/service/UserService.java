package com.ioasys.msmovie.service;

import com.ioasys.msmovie.entities.User;

public interface UserService {
	
	User save(User user);
	User login(String email, String password);

}
