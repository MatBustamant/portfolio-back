package com.matbustamant.beportfolio.controllers;

import com.matbustamant.beportfolio.models.Project;
import com.matbustamant.beportfolio.services.ProjectService;
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
@RequestMapping("api/portfolio/project")
@RequiredArgsConstructor
public class ProjectController {
	
         private final ProjectService projectInterface;

         @PostMapping ("/create")
         public Project createProject (@Valid @RequestBody Project project) {
                  return projectInterface.saveProject(project);
         }

         @GetMapping ("/read")
         public List<Project> getProjects () {
                  return projectInterface.getProjects();
         }
         
         @GetMapping ("/read/{id}")
         public Project getProjectById (@PathVariable Integer id) {
                  return projectInterface.findProjectById(id);
         }

         @PutMapping ("/update")
         public Project updateProject (@Valid @RequestBody Project project) {
                  return projectInterface.saveProject(project);
         }

         @DeleteMapping ("/delete/{id}")
         public void deleteProject (@PathVariable Integer id) {
                  projectInterface.deleteProject(id);
         }

}
