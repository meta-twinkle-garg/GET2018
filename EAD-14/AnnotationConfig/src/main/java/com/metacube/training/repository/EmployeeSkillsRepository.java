package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkill, Integer> {

	@Query("select skillId from EmployeeSkill where empId=?1")
	public List<Integer> getEmployeeSkillsById(int id);
	
	
}
