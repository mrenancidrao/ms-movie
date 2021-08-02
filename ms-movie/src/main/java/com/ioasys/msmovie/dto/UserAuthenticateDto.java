package com.ioasys.msmovie.dto;

import com.ioasys.msmovie.entities.User;

public class UserAuthenticateDto {
	
	private String name;
	private String email;
	private String token;
	private String tipo;
	
	public UserAuthenticateDto() {
		
	}
	
	public UserAuthenticateDto(String name, String email, String token, String tipo) {
		super();
		this.name = name;
		this.email = email;
		this.token = token;
		this.tipo = tipo;
	}
	
	public static UserAuthenticateDto toDto(User user, String tipo) {
		return new UserAuthenticateDto(user.getName(), user.getEmail(), user.getToken(), tipo);
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}
}
