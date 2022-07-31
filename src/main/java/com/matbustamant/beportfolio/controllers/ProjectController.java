package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.dtos.Message;
import com.matbustamant.beportfolio.models.Project;
import com.matbustamant.beportfolio.services.ProjectService;
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
@RequestMapping("api/portfolio/project")
@RequiredArgsConstructor
public class ProjectController {
	
         private final ProjectService projectInterface;

         @PostMapping ("/create")
         public ResponseEntity<?> createProject (@Valid @RequestBody Project project, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/portfolio/project/create").toUriString());
		
                  return ResponseEntity.created(uri).body(projectInterface.saveProject(project));
         }

         @GetMapping ("/read")
         public ResponseEntity<List<Project>> getProjects () {
                  return ResponseEntity.ok().body(projectInterface.getProjects());
         }
         
         @GetMapping ("/read/{id}")
         public ResponseEntity<Project> getProjectById (@PathVariable Integer id) {
		Project project = projectInterface.findProjectById(id);
                  if (project == null) {
			return ResponseEntity.notFound().build();
         }
		return ResponseEntity.ok().body(project);
         }

         @PutMapping ("/update")
         public ResponseEntity<?> updateProject (@Valid @RequestBody Project project, BindingResult bindingResult) {
		Project p = projectInterface.findProjectById(project.getId());
		if (p != null) {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.badRequest().body(new Message("Error. Campos inválidos."));
         }
			return ResponseEntity.ok().body(projectInterface.saveProject(project));
		}
                  return ResponseEntity.notFound().build();
         }

         @DeleteMapping ("/delete/{id}")
         public ResponseEntity deleteProject (@PathVariable Integer id) {
                  if (projectInterface.deleteProject(id)) {
			return ResponseEntity.ok().build();
         }
		return ResponseEntity.notFound().build();
         }

}
