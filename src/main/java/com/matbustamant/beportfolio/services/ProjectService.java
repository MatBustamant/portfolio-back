package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Project;
import java.util.List;

public interface ProjectService {
		
         public List<Project> getProjects ();

         public Project saveProject(Project project);

         public boolean deleteProject(Integer id);

         public Project findProjectById(Integer id);

}
