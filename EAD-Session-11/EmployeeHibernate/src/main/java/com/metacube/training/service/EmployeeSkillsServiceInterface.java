package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface EmployeeSkillsServiceInterface {

	public List<Skill> getEmployeeSkillsById(int id);

	List<Skill> getOtherSkills(int id);

	void addEmployeeSkill(int skillId, int empId); 
}
