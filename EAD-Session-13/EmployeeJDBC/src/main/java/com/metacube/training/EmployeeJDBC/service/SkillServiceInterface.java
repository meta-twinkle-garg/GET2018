package com.metacube.training.EmployeeJDBC.service;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Skill;

public interface SkillServiceInterface {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	boolean createSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean deleteSkill(int id);

}
