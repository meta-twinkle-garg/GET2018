package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeSkillsRepository;

@Service
public class EmployeeSkillsService implements EmployeeSkillsServiceInterface {

	@Autowired
	EmployeeSkillsRepository employeeSkillsRepository;
	
	
	@Override
	@Transactional
	public List<Integer> getEmployeeSkillsById(int id) {
		return employeeSkillsRepository.getEmployeeSkillsById(id);
	}



	@Override
	public void addEmployeeSkill(int skillId, int empId) {
		List<Integer> skills=getEmployeeSkillsById(empId);
		System.out.println(skills);
		for(Integer skill : skills){
			if(skillId==skill){
				return;
			}
		}
		EmployeeSkill employeeSkill=new EmployeeSkill();
		employeeSkill.setEmpId(empId);
		employeeSkill.setSkillId(skillId);
		employeeSkillsRepository.save(employeeSkill);
		
	}

}
