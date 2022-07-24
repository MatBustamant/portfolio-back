package com.matbustamant.beportfolio.security.models;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MainUser implements UserDetails{
	
	private final String name;

	private final String surname;

	private final String email;

	private final String password;

	private final Collection<? extends GrantedAuthority> authorities;

	public MainUser(String name, String surname, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public static MainUser build(User user) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> { 
			authorities.add(new SimpleGrantedAuthority(role.getRoleName().getName()));
		});
		return new MainUser(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), authorities);
	}
}
