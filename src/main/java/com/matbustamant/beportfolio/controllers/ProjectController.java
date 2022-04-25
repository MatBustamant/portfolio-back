package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Project;
import com.matbustamant.beportfolio.services.ProjectService;
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
@RequestMapping("api/project")
public class ProjectController {
	
         @Autowired
         private ProjectService projectInterface;

	@PreAuthorize("hasRole('ADMIN')")
         @PostMapping ("/create")
         public Project createProject (@Valid @RequestBody Project project) {
                  return projectInterface.saveProject(project);
         }

         @GetMapping ("/read")
         public List<Project> getProjects () {
                  return projectInterface.getProject();
         }
         
         @GetMapping ("/read/{id}")
         public Project getProjectById (@PathVariable Integer id) {
                  return projectInterface.findProjectById(id);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @PutMapping ("/update")
         public Project updateProject (@Valid @RequestBody Project project) {
                  return projectInterface.saveProject(project);
         }

	@PreAuthorize("hasRole('ADMIN')")
         @DeleteMapping ("/delete/{id}")
         public void deleteProject (@PathVariable Integer id) {
                  projectInterface.deleteProject(id);
         }
	
}
