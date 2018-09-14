package com.metacube.training.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;



@Service
public class SkillService implements SkillServiceInterface {

	@Autowired
	private SkillDAO skillDAO;
	
	
	@Override
	public Skill getSkillById(int id) {
		
		return skillDAO.getSkillById(id);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}
	@Override
	public void createSkill(Skill skill) {
		 skillDAO.createSkill(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return skillDAO.updateSkill(skill);
		
	}

	@Override
	public boolean deleteSkill(int id) {
		Skill skill=skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);
		
	}

	@Override
	public Skill getSkillByName(String skill) {
		return skillDAO.getSkillByName(skill);
	}

}