package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeeJDBC.mapper.EmployeeMapper;
import com.metacube.training.EmployeeJDBC.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		public EmployeeDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}

		private final String SQL_FIND_EMPLOYEE = "select * from employee where emp_code = ?";
		private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET first_name=?, last_name=?, skype_id=?, primary_contact_no=?,"
				+ "secondary_contact_no=? , profile_picture=?, dob=?, gender=?, password=? WHERE emp_code=?";
		private final String SQL_GET_ALL = "select * from employee";
		private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee(first_name, email_id, gender, dob) VALUES(?,?,?,?) ";
		private final String SQL_DELETE_EMPLOYEE ="Delete from employee where emp_code=?";
		private final String SQL_CHECK_LOGIN="SELECT * FROM EMPLOYEE WHERE email_id=? AND password=?";
		
		@Override
		public Employee getEmployeeById(int id) {
			return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { id }, new EmployeeMapper());
		}

		@Override
		public List<Employee> getAllEmployee() {
			return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
		}


		@Override
		public boolean updateEmployee(Employee employee) {
			return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getSkypeId(),
					employee.getPrimaryContactNumber(), employee.getSecondaryContactNumber(), employee.getProfilePicture(),
					employee.getDob(), employee.getGender(), employee.getPassword(), employee.getId()) > 0;
		}

		@Override
		public boolean createEmployee(Employee employee) {
			return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,employee.getFirstName(),employee.getEmailId(), employee.getGender(), employee.getDob() ) > 0;
		}

		@Override
		public boolean deleteEmployee(Employee employee) {
			return jdbcTemplate.update(SQL_DELETE_EMPLOYEE,employee.getId() ) > 0;
		}

		@Override
		public Employee checkLogin(String username, String password) {
			return jdbcTemplate.queryForObject(SQL_CHECK_LOGIN, new Object[] { username, password }, new EmployeeMapper());
		}

		
}
