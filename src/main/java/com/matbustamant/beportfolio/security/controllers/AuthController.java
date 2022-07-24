package com.matbustamant.beportfolio.security.controllers;

import com.matbustamant.beportfolio.dtos.Message;
import com.matbustamant.beportfolio.security.dtos.JwtDTO;
import com.matbustamant.beportfolio.security.dtos.LoginUser;
import com.matbustamant.beportfolio.security.dtos.NewUser;
import com.matbustamant.beportfolio.security.jwt.JwtProvider;
import com.matbustamant.beportfolio.security.models.User;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matbustamant.beportfolio.security.services.UserService;
import java.net.URI;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final UserService userInterface;
	private final JwtProvider jwtProvider;
	
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userInterface.getUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(userInterface.getUserById(id));
	}
	
	@PostMapping("/user/new")
	public ResponseEntity<?> createUser(@RequestBody NewUser newUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
		}
		if (userInterface.existsByEmail(newUser.getEmail())) {
			return ResponseEntity.badRequest().body(new Message("Error. El email especificado ya existe."));
		}
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/user/new").toUriString());
		
		User user = new User(newUser.getName(), newUser.getSurname(), newUser.getEmail(),newUser.getPassword());
		userInterface.addRolesToUser(user, newUser.getRoles());
		
		return ResponseEntity.created(uri).body(userInterface.saveUser(user));
	}
	
	@PatchMapping("/user/{id}/addrole")
	public ResponseEntity<?> addRoleToUser(@PathVariable Integer id, @RequestBody Collection<String> newRoles) {
		if (newRoles.stream().anyMatch(x -> !"ADMIN".equals(x) && !"USER".equals(x))) {
			return ResponseEntity.badRequest().body(new Message("Error. No es posible agregar los roles especificados."));
		}
		
		User user = userInterface.getUserById(id);
		
		List<String> roles = user.getRoles().stream().map(role -> role.getRoleName().getName()).collect(Collectors.toList());
		if (newRoles.contains("ADMIN") && roles.contains("ADMIN") || newRoles.contains("USER") && roles.contains("USER")) {
			return ResponseEntity.badRequest().body(new Message("Error. No es posible agregar los roles especificados."));
		}
		
		return ResponseEntity.ok().body(userInterface.addRolesToUser(user, newRoles));
	}
	
	//algo está raro aquí. creo. probar luego.
	@PatchMapping("/user/{id}/removerole")
	public ResponseEntity<?> removeRoleFromUser(@PathVariable Integer id, @RequestBody Collection<String> roles) {
		User user = userInterface.getUserById(id);
		if (roles.stream().anyMatch(x -> !"ADMIN".equals(x)) || !userInterface.removeRolesFromUser(user, roles)) {
			return ResponseEntity.badRequest().body(new Message("Error. No es posible quitar los roles especificados."));
		}
		
		return ResponseEntity.ok().body(user);
	}
	
	//----------------------------------
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
		}
		
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		JwtDTO jwtDto = new JwtDTO(jwt);
		
		return ResponseEntity.ok().body(jwtDto);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<JwtDTO> refresh(@RequestBody JwtDTO dto) throws ParseException {
		String jwt = jwtProvider.generateRefreshToken(dto);
		JwtDTO jwtDto = new JwtDTO(jwt);
		
		return ResponseEntity.ok().body(jwtDto);
	}
}
