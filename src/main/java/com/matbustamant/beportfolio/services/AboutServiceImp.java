package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.About;
import com.matbustamant.beportfolio.repositories.AboutRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AboutServiceImp implements AboutService{
	
	private final AboutRepository aboutRepo;
	
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
			throw new IllegalStateException(String.format("La descripción con id %d no existe.", id));
		}
		aboutRepo.deleteById(id);
	}

	@Override
	public About findAboutById(Integer id) {
                  return aboutRepo.findById(id).orElse(null);
	}
	
}
