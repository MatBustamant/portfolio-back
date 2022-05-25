package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.models.MainUser;
import com.matbustamant.beportfolio.security.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserService userInterface;
	
	@Override
	public MainUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userInterface.getByEmail(email).orElseThrow(() -> 
				new UsernameNotFoundException(String.format("Error. El usuario con email %s no ha sido encontrado.", email)));
		return MainUser.build(user);
	}
    
}
