package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Project;
import java.util.List;

public interface ProjectService {
		
         //método para traer todos los registros
         public List<Project> getProject ();

         //método para dar de alta un registro
         public Project saveProject(Project project);

         //método para borrar un registro
         public void deleteProject(Integer id);

         //método para encontrar un registro
         public Project findProjectById(Integer id);

}
