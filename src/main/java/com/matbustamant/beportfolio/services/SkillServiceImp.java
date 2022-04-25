package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import com.matbustamant.beportfolio.repositories.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImp implements SkillService {
	
	@Autowired
	private SkillRepository skillRepo;

	@Override
	public List<Skill> getSkillsByType(SkillType stype) {
		return skillRepo.findAllByLinkedType(stype);
	}

	@Override
	public Skill saveSkill(Skill s) {
		return skillRepo.save(s);
	}

	@Override
	public void deleteSkill(Integer id) {
		boolean exists = skillRepo.existsById(id);
		if (!exists) {
			throw new IllegalStateException("La habilidad con id " + id + " no existe.");
		}
		skillRepo.deleteById(id);
	}

	@Override
	public Skill findSkillById(Integer id) {
		return skillRepo.findById(id).orElse(null);
	}
	
}
