package com.matbustamant.beportfolio.security.dtos;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewUser {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private Set<String> roles = new HashSet<>();

	public NewUser(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public NewUser() {
	}
}
