package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Institution;
import com.matbustamant.beportfolio.repositories.InstitutionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionServiceImp implements InstitutionService {
	
	@Autowired
	private InstitutionRepository instiRepo;

	@Override
	public List<Institution> getInstitution() {
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
			throw new IllegalStateException("La institución con id " + id + " no existe.");
		}
		instiRepo.deleteById(id);
	}

	@Override
	public Institution findInstitutionById(Integer id) {
		return instiRepo.findById(id).orElse(null);
	}
	
}
