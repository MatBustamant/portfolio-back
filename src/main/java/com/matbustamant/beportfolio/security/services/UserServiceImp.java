package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.enums.RoleName;
import com.matbustamant.beportfolio.security.models.Role;
import com.matbustamant.beportfolio.security.models.User;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.matbustamant.beportfolio.security.repositories.UserRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
	
	private final UserRepository userRepo;
	private final RoleService roleInterface;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public User getUserById (Integer id) {
		return userRepo.findById(id).orElse(null);
	}
	
	@Override
	public Optional<User> getByEmail (String email) {
		return userRepo.findByEmail(email);
	}
	
	@Override
	public boolean existsByEmail (String email) {
		return userRepo.existsByEmail(email);
	}
	
	@Override
	public User saveUser (User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User addRolesToUser (User user, Collection<String> newRoles) {
		Role roleUser = roleInterface.getByRoleName(RoleName.ROLE_USER).get();
		Role roleAdmin = roleInterface.getByRoleName(RoleName.ROLE_ADMIN).get();
		
		Set<Role> roles = user.getRoles();
		
		if (!roles.contains(roleUser)) {
			roles.add(roleUser);
		}
		if (newRoles.contains("ADMIN") && !roles.contains(roleAdmin)) {
			roles.add(roleAdmin);
		}
		user.setRoles(roles);
		return user;
	}
	
	@Override
	public Boolean removeRolesFromUser (User user, Collection<String> oldRoles) {
		if (oldRoles.contains("USER")) {
			return false;
		}
		
		Set<Role> roles = user.getRoles();
		
		if (oldRoles.contains("ADMIN")) {
			user.setRoles(roles);
			return roles.remove(roleInterface.getByRoleName(RoleName.ROLE_ADMIN).get());
			//aquí falta algo???? creo que nunca borro roles. probar luego.
		}

		return false;
	}
}
