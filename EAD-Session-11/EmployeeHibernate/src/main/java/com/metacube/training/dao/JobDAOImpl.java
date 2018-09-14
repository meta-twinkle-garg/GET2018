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








import com.metacube.training.model.Job;
import com.metacube.training.model.Job;


@Repository
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;


	@Override
	public Job getJobById(int id) {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Job.class);
		cr.add(Restrictions.eq("id", id));
		return (Job) cr.uniqueResult();
	}

	@Override
	public List<Job> getAllJobs() {
		@SuppressWarnings("deprecation")
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Job.class);
		return (List<Job>) cr.list();	
	}

	@Override
	public void createJob(Job job) {
		sessionFactory.getCurrentSession().save(job);
	}


	@Override
	public boolean updateJob(Job job) {
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        CriteriaUpdate<Job> update = cb.createCriteriaUpdate(Job.class);
        Root e = update.from(Job.class);

        update.set("title",job.getTitle());
        
        update.where(cb.equal(e.get("id"), job.getId()));

        // perform update
        return sessionFactory.getCurrentSession().createQuery(update).executeUpdate()>0;
	}
	

	@Override
	public boolean deleteJob(Job job){
		CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // create delete
        CriteriaDelete<Job> delete = cb.createCriteriaDelete(Job.class);

        // set the root class
        Root e = delete.from(Job.class);

        // set where clause
        delete.where(cb.equal(e.get("id"), job.getId()));

        // perform update
        return sessionFactory.getCurrentSession().createQuery(delete).executeUpdate()>0;
	}
	
}
