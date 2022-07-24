package com.matbustamant.beportfolio.security.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUser {
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;

	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public LoginUser() {
	}
}
