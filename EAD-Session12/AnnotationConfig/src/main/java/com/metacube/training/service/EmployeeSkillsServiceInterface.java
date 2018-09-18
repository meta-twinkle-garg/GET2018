package com.metacube.training.service;

import java.util.List;


public interface EmployeeSkillsServiceInterface {

	public List<Integer> getEmployeeSkillsById(int id);


	void addEmployeeSkill(int skillId, int empId); 
}
