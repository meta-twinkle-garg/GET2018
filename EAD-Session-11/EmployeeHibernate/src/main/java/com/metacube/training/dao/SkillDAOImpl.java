package com.metacube.training.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Skill;
import com.metacube.training.model.Skill;



@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO {
	@Autowired
	   private SessionFactory sessionFactory;


	@Override
	public Skill getSkillById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		cr.add(Restrictions.eq("id", id));
		return (Skill) cr.uniqueResult();
	}

	@Override
	public List<Skill> getAllSkills() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		return (List<Skill>) cr.list();	
	}

	@Override
	public void createSkill(Skill skill) {
		sessionFactory.getCurrentSession().save(skill);
	}


	@Override
	public boolean updateSkill(Skill skill) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

     CriteriaUpdate<Skill> update = cb.createCriteriaUpdate(Skill.class);
     Root e = update.from(Skill.class);

     update.set("name",skill.getName());
     
     update.where(cb.equal(e.get("id"), skill.getId()));

     // perform update
     return sessionFactory.getCurrentSession().createQuery(update).executeUpdate()>0;
	}
	

	@Override
	public boolean deleteSkill(Skill skill){
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

     // create delete
     CriteriaDelete<Skill> delete = cb.createCriteriaDelete(Skill.class);

     // set the root class
     Root e = delete.from(Skill.class);

     // set where clause
     delete.where(cb.equal(e.get("id"), skill.getId()));

     // perform update
     return sessionFactory.getCurrentSession().createQuery(delete).executeUpdate()>0;
	}

	@Override
	public Skill getSkillByName(String skill) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		cr.add(Restrictions.eq("name", skill));
		return (Skill) cr.uniqueResult();
	}
	
}
