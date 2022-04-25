package com.matbustamant.beportfolio.security.controllers;

import com.matbustamant.beportfolio.dtos.Message;
import com.matbustamant.beportfolio.security.dtos.JwtDTO;
import com.matbustamant.beportfolio.security.dtos.LoginUser;
import com.matbustamant.beportfolio.security.dtos.NewUser;
import com.matbustamant.beportfolio.security.enums.RoleName;
import com.matbustamant.beportfolio.security.jwt.JwtProvider;
import com.matbustamant.beportfolio.security.models.Role;
import com.matbustamant.beportfolio.security.models.User;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matbustamant.beportfolio.security.services.RoleService;
import com.matbustamant.beportfolio.security.services.UserService;

@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userInterface;
	
	@Autowired
	private RoleService roleInterface;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/new")
	public ResponseEntity<?> createNewUser (@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
		}
		if (userInterface.existsByUsername(newUser.getUsername())) {
			return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}
		if (userInterface.existsByEmail(newUser.getEmail())) {
			return new ResponseEntity(new Message("ese email ya existe"), HttpStatus.BAD_REQUEST);
		}
		User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
				passwordEncoder.encode(newUser.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleInterface.getByRoleName(RoleName.BASIC_ROLE).get());
		if (newUser.getRoles().contains("admin")) {
			roles.add(roleInterface.getByRoleName(RoleName.ADMIN_ROLE).get());
		}
		user.setRoles(roles);
		userInterface.saveUser(user);
		return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login (@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
		}
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
