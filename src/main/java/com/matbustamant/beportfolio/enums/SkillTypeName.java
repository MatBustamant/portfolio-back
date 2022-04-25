package com.matbustamant.beportfolio.enums;

public enum SkillTypeName {
	
	SOFT_SKILL ("Soft"),
	HARD_SKILL ("Hard"),
	LANGUAGE ("Idioma"),
	PROGRAMMING_LANGUAGE ("Lenguaje de programación");
	
	private final String name;

	private SkillTypeName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
