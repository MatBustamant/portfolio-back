package com.matbustamant.beportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BeportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeportfolioApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/auth/login").allowedOrigins("https://portfolio-angular-9c08e.web.app/").allowedMethods("POST").maxAge(3600);
				registry.addMapping("/api/auth/refresh").allowedOrigins("https://portfolio-angular-9c08e.web.app/").allowedMethods("POST").maxAge(3600);
				registry.addMapping("/api/portfolio/**").allowedOrigins("https://portfolio-angular-9c08e.web.app/").allowedMethods("*").maxAge(3600);
			}
		};
	}

}
