package com.matbustamant.beportfolio.security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDTO {
	
	private String token;

	public JwtDTO(String token) {
		this.token = token;
	}

	public JwtDTO() {
	}
}
