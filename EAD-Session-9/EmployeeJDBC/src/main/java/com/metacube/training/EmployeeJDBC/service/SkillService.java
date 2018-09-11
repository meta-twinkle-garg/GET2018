package com.metacube.training.EmployeeJDBC.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeeJDBC.dao.SkillDAO;
import com.metacube.training.EmployeeJDBC.model.Skill;

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
	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}

}