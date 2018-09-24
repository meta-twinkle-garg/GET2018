package com.metacube.training.EmployeeJDBC.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeeJDBC.model.Employee;


public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rset, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setId(rset.getInt("emp_code"));
		employee.setFirstName(rset.getString("first_name"));
		employee.setLastName(rset.getString("last_name"));
		employee.setDob(rset.getDate("dob"));
		employee.setGender(rset.getString("gender"));
		employee.setPrimaryContactNumber(rset.getString("primary_contact_no"));
		employee.setSecondaryContactNumber(rset.getString("secondary_contact_no"));
		employee.setEmailId(rset.getString("email_id"));
		employee.setSkypeId(rset.getString("skype_id"));
		employee.setProfilePicture(rset.getString("profile_picture"));
		return employee;
	}
	}
