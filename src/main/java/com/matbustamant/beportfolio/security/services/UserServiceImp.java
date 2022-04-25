package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.models.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.matbustamant.beportfolio.security.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository userRepo; 
	
	@Override
	public Optional<User> getByUsername (String username) {
		return userRepo.findByUsername(username);
	}
	
	@Override
	public boolean existsByUsername (String username) {
		return userRepo.existsByUsername(username);
	}
	
	@Override
	public boolean existsByEmail (String email) {
		return userRepo.existsByEmail(email);
	}
	
	@Override
	public User saveUser (User user) {
		return userRepo.save(user);
	}
}
