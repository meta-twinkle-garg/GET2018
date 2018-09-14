package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class EmployeeSkillsDAOImpl implements EmployeeSkillsDAO {

	@Autowired
	   private SessionFactory sessionFactory;
	@Override
	public List<Skill> getEmployeeSkillsById(int id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(EmployeeSkill.class);
		cr.add(Restrictions.eq("empId", id));
		List<EmployeeSkill> listOfEmployeeSkills= (List<EmployeeSkill>)  cr.list();
		
		List<Skill> listOfSkills =new ArrayList<>();
		for(EmployeeSkill skill:listOfEmployeeSkills){
			Criteria cr2 = sessionFactory.getCurrentSession().createCriteria(Skill.class);
			cr2.add(Restrictions.eq("id", skill.getSkillId()));
			listOfSkills.add((Skill)cr2.uniqueResult());
		}
		return listOfSkills;
	}
	@Override
	public List<Skill> getOtherSkills(int id) {
		List<Skill> listOfSkills=getEmployeeSkillsById(id);
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		for(Skill skill:listOfSkills){
			cr.add(Restrictions.ne("id", skill.getId()));
		}
		
		return (List<Skill>) cr.list();
	}
	@Override
	public void addEmployeeSkill(int skillId, int empId) {
		EmployeeSkill employeeSkill=new EmployeeSkill();
		employeeSkill.setEmpId(empId);
		employeeSkill.setSkillId(skillId);
		sessionFactory.getCurrentSession().save(employeeSkill);
		
	}

}
