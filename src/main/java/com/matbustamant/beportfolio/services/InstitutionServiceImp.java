package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Institution;
import com.matbustamant.beportfolio.repositories.InstitutionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionServiceImp implements InstitutionService {
	
	private final InstitutionRepository instiRepo;

	@Override
	public List<Institution> getInstitutions() {
		return instiRepo.findAll();
	}

	@Override
	public Institution saveInstitution(Institution institution) {
		return instiRepo.save(institution);
	}

	@Override
	public void deleteInstitution(Integer id) {
		boolean exists = instiRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException(String.format("La institución con id %d no existe.", id));
		}
		instiRepo.deleteById(id);
	}

	@Override
	public Institution findInstitutionById(Integer id) {
		return instiRepo.findById(id).orElse(null);
	}
	
}
