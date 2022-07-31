package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.dtos.Message;
import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.services.SkillService;
import java.net.URI;
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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/portfolio/skill")
@RequiredArgsConstructor
public class SkillController {
	
         private final SkillService skillInterface;

         @PostMapping ("/create")
         public ResponseEntity<?> createSkill (@Valid @RequestBody Skill skill, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
		 
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/portfolio/skill/create").toUriString());
		
                  return ResponseEntity.created(uri).body(skillInterface.saveSkill(skill));
         }
		 
	@GetMapping("/read")
	public ResponseEntity<List<Skill>> getSkills() {
		return ResponseEntity.ok().body(skillInterface.getSkills());
	}

         @GetMapping ("/read/st{id}")
         public ResponseEntity<List<Skill>> getSkillsByType (@PathVariable Short id) {
		List<Skill> lista = skillInterface.getSkillsByType(id);
		if (lista == null) {
			ResponseEntity.notFound().build();
         }
                  return ResponseEntity.ok().body(lista);
         }
         
         @GetMapping ("/read/{id}")
         public ResponseEntity<Skill> getSkillById (@PathVariable Integer id) {
		Skill skill = skillInterface.findSkillById(id);
		if (skill == null) {
			return ResponseEntity.notFound().build();
         }
                  return ResponseEntity.ok().body(skill);
         }

         @PutMapping ("/update")
         public ResponseEntity<?> updateSkill (@Valid @RequestBody Skill skill, BindingResult bindingResult) {
		Skill s = skillInterface.findSkillById(skill.getId());
		if (s != null) {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
			return ResponseEntity.ok().body(skillInterface.saveSkill(skill));
		}
                  return ResponseEntity.notFound().build();
         }

         @DeleteMapping ("/delete/{id}")
         public ResponseEntity deleteSkill (@PathVariable Integer id) {
                  if (skillInterface.deleteSkill(id)) {
			return ResponseEntity.ok().build();
         }
		return ResponseEntity.notFound().build();
         }

}
