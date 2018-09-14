package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;


public interface SkillServiceInterface {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	void createSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean deleteSkill(int id);

	Skill getSkillByName(String skill);

}
