package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import com.matbustamant.beportfolio.services.SkillService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/portfolio/skill")
@RequiredArgsConstructor
public class SkillController {
	
         private final SkillService skillInterface;

         @PostMapping ("/create")
         public Skill createSkill (@Valid @RequestBody Skill skill) {
                  return skillInterface.saveSkill(skill);
         }

         @GetMapping ("/read/st{stype}")
         public List<Skill> getSkillsByType (@PathVariable SkillType stype) {
                  return skillInterface.getSkillsByType(stype);
         } 
         
         @GetMapping ("/read/{id}")
         public Skill getSkillById (@PathVariable Integer id) {
                  return skillInterface.findSkillById(id);
         }

         @PutMapping ("/update")
         public Skill updateSkill (@Valid @RequestBody Skill skill) {
                  return skillInterface.saveSkill(skill);
         }

         @DeleteMapping ("/delete/{id}")
         public void deleteSkill (@PathVariable Integer id) {
                  skillInterface.deleteSkill(id);
         }

}
