package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import java.util.List;

public interface SkillService {
	
         public List<Skill> getSkillsByType(SkillType stype);

         public Skill saveSkill(Skill s);

         public void deleteSkill(Integer id);

         public Skill findSkillById(Integer id);

}
