package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import com.matbustamant.beportfolio.repositories.BackgroundRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BackgroundServiceImp implements BackgroundService{
	
	private final BackgroundRepository bgRepo;

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
			throw new IllegalStateException(String.format("El antecedente con el id %d no existe.", id));
		}
		bgRepo.deleteById(id);
	}

	@Override
	public Background findBackgroundById(Integer id) {
		return bgRepo.findById(id).orElse(null);
	}

}
