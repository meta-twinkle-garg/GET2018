package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Skill;


public interface SkillRepository  extends JpaRepository<Skill, Integer> {

	Skill findByName(String skill);

	@Modifying
	@Query("delete from Skill where id=?1")
	void deleteSkillById(int id);

}
