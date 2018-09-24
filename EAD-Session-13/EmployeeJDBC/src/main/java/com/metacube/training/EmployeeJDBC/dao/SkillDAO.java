package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	boolean createSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean deleteSkill(Skill skill);

}
