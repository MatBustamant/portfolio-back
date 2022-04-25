package com.matbustamant.beportfolio.repositories;

import com.matbustamant.beportfolio.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{

}
