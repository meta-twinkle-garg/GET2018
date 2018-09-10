package com.metacube.training.EmployeePortal.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.EmployeePortal.dao.ProjectDAO;
import com.metacube.training.EmployeePortal.dao.SkillDAO;
import com.metacube.training.EmployeePortal.model.Project;
import com.metacube.training.EmployeePortal.model.Skill;

public class SkillService {

	public static boolean createSkill(Skill skill) {
		String name=skill.getName();
		return SkillDAO.createSkill(name);
		
		
	}

	public static List<Skill> getAllSkills() {
		ResultSet rset= SkillDAO.getAllSkills();
		List<Skill> skills=new ArrayList<Skill>();
		try {
			while(rset.next()){
				Skill skill=new Skill();
				skill.setId(rset.getInt("id"));
				skill.setName(rset.getString("name"));
				skills.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skills;
	}



}
