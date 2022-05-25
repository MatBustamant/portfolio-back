package com.matbustamant.beportfolio.security.jwt;

import com.matbustamant.beportfolio.security.models.MainUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtProvider {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private int durationInSec;
	
	public static final String BEARER = "Bearer ";
	
	public String generateToken(Authentication authentication) {
		MainUser mainUser = (MainUser) authentication.getPrincipal();
		
		Date tokenExpirationDate = new Date(new Date().getTime() + durationInSec * 1000);
		
		return Jwts.builder()
				.setHeaderParam("typ", Header.JWT_TYPE)
				.setSubject(mainUser.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(tokenExpirationDate)
				.claim("roles", mainUser.getAuthorities())
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return decodeToken(token).getBody().getSubject();
	}
	
	public Collection<SimpleGrantedAuthority> getRolesFromToken(String token) {
		return decodeToken(token).getBody().get("roles", ArrayList.class);
	}
	
	public boolean isValid(String token) {
		try {
			decodeToken(token);
			return true;

		}catch (MalformedJwtException e) {
			log.info("Token malformado: {}", e.getMessage());
			throw e;
		}catch (UnsupportedJwtException e) {
			log.info("Token no soportado: {}", e.getMessage());
			throw e;
		}catch (ExpiredJwtException e) {
			log.info("Token expirado: {}", e.getMessage());
			throw e;
		}catch (IllegalArgumentException e) {
			log.info("Token vacío: {}", e.getMessage());
			throw e;
		}catch (SignatureException e) {
			log.info("Error en la firma del token JWT: {}", e.getMessage());
			throw e;
		}
//		return false;
	}
	
	public Jws<Claims> decodeToken(String token){
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
	}
}
