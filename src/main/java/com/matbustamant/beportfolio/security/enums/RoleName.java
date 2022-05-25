package com.matbustamant.beportfolio.security.enums;

public enum RoleName {
	
	ROLE_ADMIN ("ADMIN"),
	ROLE_USER ("USER");
	
	private final String name;

	private RoleName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
