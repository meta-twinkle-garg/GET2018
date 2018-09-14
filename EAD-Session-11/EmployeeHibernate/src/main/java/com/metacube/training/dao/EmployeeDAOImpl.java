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





import com.metacube.training.model.Employee;
import com.metacube.training.model.Project;




@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {


		@Autowired
		   private SessionFactory sessionFactory;
		
		
		@Override
		public Employee getEmployeeById(int id) {
			@SuppressWarnings("deprecation")
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Employee.class);
			cr.add(Restrictions.eq("id", id));
			return (Employee) cr.uniqueResult();
		}

		@Override
		public List<Employee> getAllEmployee() {
			@SuppressWarnings("deprecation")
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Employee.class);
			return (List<Employee>) cr.list();
		}


		@Override
		public boolean updateEmployee(Employee employee) {
			CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

	        CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);
	        Root e = update.from(Employee.class);

	        update.set("firstName",employee.getFirstName());
	        update.set("lastName",employee.getLastName());
	        update.set("skypeId",employee.getSkypeId());
	        update.set("primaryContactNumber", employee.getPrimaryContactNumber());
	        update.set("secondaryContactNumber", employee.getSecondaryContactNumber());
	        update.set("profilePicture", employee.getProfilePicture());
	        update.set("gender", employee.getGender());
	        update.set("dob", employee.getDob());
	        update.set("password", employee.getPassword());
	        update.where(cb.equal(e.get("id"), employee.getId()));

	        return sessionFactory.getCurrentSession().createQuery(update).executeUpdate()>0;
		}

		@Override
		public void createEmployee(Employee employee) {
			sessionFactory.getCurrentSession().save(employee);
		}

		@Override
		public boolean deleteEmployee(Employee employee) {
			CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();

	        // create delete
	        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);

	        // set the root class
	        Root e = delete.from(Employee.class);

	        // set where clause
	        delete.where(cb.equal(e.get("id"), employee.getId()));

	        // perform update
	        return sessionFactory.getCurrentSession().createQuery(delete).executeUpdate()>0;
		}

		@Override
		public Employee checkLogin(String username, String password) {
			@SuppressWarnings("deprecation")
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Employee.class);
			cr.add(Restrictions.eq("emailId", username));
			cr.add(Restrictions.eq("password", password));
			return (Employee) cr.uniqueResult();
		}

		
}
