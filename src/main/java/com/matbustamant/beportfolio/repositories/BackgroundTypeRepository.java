package com.matbustamant.beportfolio.repositories;

import com.matbustamant.beportfolio.models.BackgroundType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundTypeRepository extends JpaRepository<BackgroundType, Short>{

}