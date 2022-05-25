package com.matbustamant.beportfolio.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtEntryPoint implements AuthenticationEntryPoint{

	@Override 
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		log.info("No autorizado: {}", authException.getMessage());
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		ZonedDateTime d = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.systemDefault());
		String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(d);
		
		String message = (request.getAttribute("exception") != null) ?
				(String) request.getAttribute("exception")
				: authException.getMessage();
		
		LinkedHashMap throwable = new LinkedHashMap<>();
		throwable.put("timestamp", timestamp);
		throwable.put("status", response.getStatus());
		throwable.put("error", HttpStatus.UNAUTHORIZED.getReasonPhrase());
		throwable.put("message", message);
		throwable.put("path", request.getAttribute("uripath"));

		byte[] body = new ObjectMapper().writeValueAsBytes(throwable);

		response.getOutputStream().write(body);
	}
    
}
