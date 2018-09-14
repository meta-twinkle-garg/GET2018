package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {

	
	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public Project getProjectById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Project.class);
		cr.add(Restrictions.eq("id", id));
		return (Project) cr.uniqueResult();
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {

		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Project.class);
		return (List<Project>) cr.list();	
	}

	@Override
	public boolean deleteProject(Project project) {

		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // create delete
        CriteriaDelete<Project> delete = cb.createCriteriaDelete(Project.class);

        // set the root class
        Root e = delete.from(Project.class);

        // set where clause
        delete.where(cb.equal(e.get("id"), project.getId()));

        // perform update
        return sessionFactory.getCurrentSession().createQuery(delete).executeUpdate()>0;
	}

	@Override
	public boolean updateProject(Project project) {
	
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        CriteriaUpdate<Project> update = cb.createCriteriaUpdate(Project.class);
        Root e = update.from(Project.class);

        update.set("name",project.getName());
        update.set("description", project.getDescription());
        update.set("startDate",project.getStartDate());
        update.set("endDate",project.getEndDate());
        update.where(cb.equal(e.get("id"), project.getId()));

        // perform update
        return sessionFactory.getCurrentSession().createQuery(update).executeUpdate()>0;
    }


	@Override
	public void createProject(Project project) {
		
		sessionFactory.getCurrentSession().save(project);
	}

	

}