package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Background;
import com.matbustamant.beportfolio.models.BackgroundType;
import com.matbustamant.beportfolio.repositories.BackgroundRepository;
import com.matbustamant.beportfolio.repositories.BackgroundTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BackgroundServiceImp implements BackgroundService{
	
	private final BackgroundRepository bgRepo;
	private final BackgroundTypeRepository bgtypeRepo;

	@Override
	public List<Background> getBackgroundsByType(Short id) {
		BackgroundType bgtype = bgtypeRepo.findById(id).orElse(null);
		if (bgtype == null) {
			return null;
		}
                  return bgRepo.findAllByLinkedType(bgtype);
	}

	@Override
	public Background saveBackground(Background bg) {
		return bgRepo.save(bg);
	}

	@Override
	public boolean deleteBackground(Integer id) {
		if (!bgRepo.existsById(id)) {
			return false;
		}
		bgRepo.deleteById(id);
		return true;
	}

	@Override
	public Background findBackgroundById(Integer id) {
		return bgRepo.findById(id).orElse(null);
	}

}
