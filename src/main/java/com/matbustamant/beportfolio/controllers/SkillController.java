package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import com.matbustamant.beportfolio.services.SkillService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
@RequestMapping("api/skill")
public class SkillController {
	
         @Autowired
         private SkillService skillInterface;

	@PreAuthorize("hasRole('ADMIN')")
         @PostMapping ("/create")
         public Skill createSkill (@Valid @RequestBody Skill skill) {
                  return skillInterface.saveSkill(skill);
         }

         @GetMapping ("/read")
         public List<Skill> getSkillsByType (SkillType stype) {
                  return skillInterface.getSkillsByType(stype);
         }
         
         @GetMapping ("/read/{id}")
         public Skill getSkillById (@PathVariable Integer id) {
                  return skillInterface.findSkillById(id);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @PutMapping ("/update")
         public Skill updateSkill (@Valid @RequestBody Skill skill) {
                  return skillInterface.saveSkill(skill);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping ("/delete/{id}")
         public void deleteSkill (@PathVariable Integer id) {
                  skillInterface.deleteSkill(id);
         }

}
