package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Project;
import com.matbustamant.beportfolio.repositories.ProjectRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {
	
	private final ProjectRepository projectRepo;

	@Override
	public List<Project> getProjects() {
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
			throw new IllegalStateException(String.format("El proyecto con id %d no existe.", id));
		}
		projectRepo.deleteById(id);
	}

	@Override
	public Project findProjectById(Integer id) {
		return projectRepo.findById(id).orElse(null);
	}
	
}
