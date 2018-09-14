package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface EmployeeSkillsDAO {

	List<Skill> getEmployeeSkillsById(int id);

	List<Skill> getOtherSkills(int id);

	void addEmployeeSkill(int skillId, int empId);
}
