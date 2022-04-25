package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.About;
import com.matbustamant.beportfolio.repositories.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImp implements AboutService{
	
	@Autowired
	private AboutRepository aboutRepo;
	
	@Override
	public List<About> getAbout() {
                  return aboutRepo.findAll();
	}

	@Override
	public About saveAbout(About about) {
		return aboutRepo.save(about);
	}

	@Override
	public void deleteAbout(Integer id) {
		boolean exists = aboutRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("La descripción con id " + id + " no existe.");
		}
		aboutRepo.deleteById(id);
	}

	@Override
	public About findAboutById(Integer id) {
                  return aboutRepo.findById(id).orElse(null);
	}
	
}
