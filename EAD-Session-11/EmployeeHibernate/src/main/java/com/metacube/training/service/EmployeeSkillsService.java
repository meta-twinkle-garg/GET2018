package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeSkillsDAO;
import com.metacube.training.model.Skill;

@Service
public class EmployeeSkillsService implements EmployeeSkillsServiceInterface {

	@Autowired
	EmployeeSkillsDAO employeeSkillsDAO;
	
	@Override
	public List<Skill> getEmployeeSkillsById(int id) {
		return employeeSkillsDAO.getEmployeeSkillsById(id);
	}

	@Override
	public List<Skill> getOtherSkills(int id) {
		return employeeSkillsDAO.getOtherSkills(id);
	}

	@Override
	public void addEmployeeSkill(int skillId, int empId) {
		employeeSkillsDAO.addEmployeeSkill(skillId,empId);
		
	}

}
