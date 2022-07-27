package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import com.matbustamant.beportfolio.repositories.SkillRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillServiceImp implements SkillService {
	
	private final SkillRepository skillRepo;
	
	@Override
	public List<Skill> getSkills() {
		return skillRepo.findAll();
	}

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
			throw new IllegalStateException(String.format("La habilidad con id %d no existe.", id));
		}
		skillRepo.deleteById(id);
	}

	@Override
	public Skill findSkillById(Integer id) {
		return skillRepo.findById(id).orElse(null);
	}
	
}
