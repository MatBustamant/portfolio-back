package com.matbustamant.beportfolio.security.enums;

public enum RoleName {
	
	ADMIN_ROLE ("Rol administrador"),
	BASIC_ROLE ("Rol básico");
	
	private final String name;

	private RoleName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
