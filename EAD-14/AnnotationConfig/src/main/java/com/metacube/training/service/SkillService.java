package com.metacube.training.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;



@Service
public class SkillService implements SkillServiceInterface {

	@Autowired
	private SkillRepository skillRepository;
	
	
	@Override
	public Skill getSkillById(int id) {
		
		return skillRepository.findOne(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}
	@Override
	public void createSkill(Skill skill) {
		skillRepository.save(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
		
	}

	@Override
	@Transactional
	public boolean deleteSkill(int id) {
		skillRepository.deleteSkillById(id);
		return true;
		
	}

	@Override
	public Skill getSkillByName(String skill) {
		return skillRepository.findByName(skill);
	}

}