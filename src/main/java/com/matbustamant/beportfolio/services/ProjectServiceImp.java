package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Project;
import com.matbustamant.beportfolio.repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public List<Project> getProject() {
		return projectRepo.findAll();
	}

	@Override
	public Project saveProject(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public void deleteProject(Integer id) {
		boolean exists = projectRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("El proyecto con id " + id + " no existe.");
		}
		projectRepo.deleteById(id);
	}

	@Override
	public Project findProjectById(Integer id) {
		return projectRepo.findById(id).orElse(null);
	}
	
}
