package com.matbustamant.beportfolio.repositories;

import com.matbustamant.beportfolio.models.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Short>{

}
