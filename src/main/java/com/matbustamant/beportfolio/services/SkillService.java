package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import java.util.List;

public interface SkillService {
	
         //método para traer todos los registros
         public List<Skill> getSkillsByType(SkillType stype);

         //método para dar de alta un registro
         public Skill saveSkill(Skill s);

         //método para borrar un registro
         public void deleteSkill(Integer id);

         //método para encontrar un registro
         public Skill findSkillById(Integer id);

}
