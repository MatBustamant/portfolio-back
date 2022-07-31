package com.matbustamant.beportfolio.security.services;

import com.matbustamant.beportfolio.security.enums.RoleName;
import com.matbustamant.beportfolio.security.models.Role;
import java.util.Optional;

public interface RoleService {
	
	public Optional<Role> getByRoleName(RoleName roleName);
	
	public Role save(Role role);
	
}
