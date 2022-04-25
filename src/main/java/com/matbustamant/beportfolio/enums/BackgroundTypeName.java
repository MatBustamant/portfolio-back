package com.matbustamant.beportfolio.enums;

public enum BackgroundTypeName {
	
	EDUCATION ("Educación"),
	EXPERIENCE ("Experiencia");
	
	private final String name;

	private BackgroundTypeName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
