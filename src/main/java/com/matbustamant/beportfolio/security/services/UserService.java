package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.models.User;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
	
	public List<User> getUsers();
	
	public User getUserById(Integer id);

	public Optional<User> getByEmail (String email);
	
	public boolean existsByEmail (String email);
	
	public User saveUser (User user);
	
	public User addRolesToUser (User user, Collection<String> roles);
	
	public Boolean removeRolesFromUser (User user, Collection<String> oldRoles);
}
