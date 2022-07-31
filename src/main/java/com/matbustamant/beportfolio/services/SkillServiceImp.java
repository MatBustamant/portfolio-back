package com.matbustamant.beportfolio.services;

import com.matbustamant.beportfolio.models.Skill;
import com.matbustamant.beportfolio.models.SkillType;
import com.matbustamant.beportfolio.repositories.SkillRepository;
import com.matbustamant.beportfolio.repositories.SkillTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillServiceImp implements SkillService {
	
	private final SkillRepository skillRepo;
	private final SkillTypeRepository stypeRepo;
	
	@Override
	public List<Skill> getSkills() {
		return skillRepo.findAll();
	}

	@Override
	public List<Skill> getSkillsByType(Short id) {
		SkillType stype = stypeRepo.findById(id).orElse(null);
		if (stype == null) {
			return null;
		}
		return skillRepo.findAllByLinkedType(stype);
	}

	@Override
	public Skill saveSkill(Skill s) {
		return skillRepo.save(s);
	}

	@Override
	public boolean deleteSkill(Integer id) {
		if (!skillRepo.existsById(id)) {
			return false;
		}
		skillRepo.deleteById(id);
		return true;
	}

	@Override
	public Skill findSkillById(Integer id) {
		return skillRepo.findById(id).orElse(null);
	}
	
}
