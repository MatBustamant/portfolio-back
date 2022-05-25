package com.matbustamant.beportfolio.security.jwt;

import com.matbustamant.beportfolio.security.models.MainUser;
import com.matbustamant.beportfolio.security.services.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter{
	
	private final JwtProvider jwtProvider;
	private final UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			String token = getToken(request);
			
			if (token != null && jwtProvider.isValid(token)) {
				MainUser mainUser = userDetailsService.loadUserByUsername(jwtProvider.getUsernameFromToken(token));
				
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(mainUser, null, mainUser.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
				log.debug("El usuario pudo ser autenticado.");
			}

		} catch (UsernameNotFoundException e) {
			log.info(e.getMessage());
			request.setAttribute("exception", e.getMessage());
			request.setAttribute("uripath", request.getRequestURI());
			throw e;
		} catch (Exception e) {
			log.info("El usuario no pudo ser autenticado: {}", e.getMessage());
			request.setAttribute("exception", e.getMessage());
			request.setAttribute("uripath", request.getRequestURI());
			throw e;
		}
		filterChain.doFilter(request, response);
	}
	
	private String getToken (HttpServletRequest request){
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (header != null && header.startsWith(JwtProvider.BEARER)) {
			return header.replace(JwtProvider.BEARER, "");
		}
		return null;
	}
}
