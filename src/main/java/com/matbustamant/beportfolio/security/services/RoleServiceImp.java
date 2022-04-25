package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.enums.RoleName;
import com.matbustamant.beportfolio.security.models.Role;
import com.matbustamant.beportfolio.security.repositories.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImp implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Optional<Role> getByRoleName(RoleName roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}
