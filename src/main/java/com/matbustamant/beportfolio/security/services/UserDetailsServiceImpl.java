package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.models.MainUser;
import com.matbustamant.beportfolio.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userInterface;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userInterface.getByUsername(username).get();
		return MainUser.build(user);
	}
    
}
