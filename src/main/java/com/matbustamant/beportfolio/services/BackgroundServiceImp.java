package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import com.matbustamant.beportfolio.repositories.BackgroundRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackgroundServiceImp implements BackgroundService{
	
	@Autowired
	private BackgroundRepository bgRepo;

	@Override
	public List<Background> getBackgroundsByType(BackgroundType bgtype) {
                  return bgRepo.findAllByLinkedType(bgtype);
	}

	@Override
	public Background saveBackground(Background bg) {
		return bgRepo.save(bg);
	}

	@Override
	public void deleteBackground(Integer id) {
		boolean exists = bgRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("El antecedente con el id " + id + " no existe.");
		}
		bgRepo.deleteById(id);
	}

	@Override
	public Background findBackgroundById(Integer id) {
		return bgRepo.findById(id).orElse(null);
	}

}
