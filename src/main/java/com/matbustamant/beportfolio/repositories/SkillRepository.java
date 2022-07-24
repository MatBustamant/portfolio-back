package com.matbustamant.beportfolio.repositories;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
	
	public List<Skill> findAllByLinkedType(SkillType stype); //quizá ande mal, probar luego.
	
}
