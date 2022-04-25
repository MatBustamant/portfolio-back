package com.matbustamant.beportfolio.security.repositories;

import com.matbustamant.beportfolio.security.enums.RoleName;
import com.matbustamant.beportfolio.security.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short>{
	
	Optional<Role> findByRoleName (RoleName roleName);
}
