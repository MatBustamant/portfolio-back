package com.matbustamant.beportfolio.security.repositories;

import com.matbustamant.beportfolio.security.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername (String username);
	
	boolean existsByUsername (String username);
	
	boolean existsByEmail (String email);
}
