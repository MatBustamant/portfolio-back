package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.models.User;
import java.util.Optional;

public interface UserService {
	
	public Optional<User> getByUsername (String username);
	
	public boolean existsByUsername (String username);
	
	public boolean existsByEmail (String email);
	
	public User saveUser (User user);
}
