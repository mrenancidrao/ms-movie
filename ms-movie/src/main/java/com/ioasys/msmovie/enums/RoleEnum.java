package com.ioasys.msmovie.enums;

public enum RoleEnum {

	ADMIN(1,"ADMIN"),
	USER(2,"USER");
	
	private int id;
	private String name;

	RoleEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
