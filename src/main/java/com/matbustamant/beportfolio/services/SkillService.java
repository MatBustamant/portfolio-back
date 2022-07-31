package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import java.util.List;

public interface SkillService {
	
	public List<Skill> getSkills();
	
         public List<Skill> getSkillsByType(Short id);

         public Skill saveSkill(Skill s);

         public boolean deleteSkill(Integer id);

         public Skill findSkillById(Integer id);

}
