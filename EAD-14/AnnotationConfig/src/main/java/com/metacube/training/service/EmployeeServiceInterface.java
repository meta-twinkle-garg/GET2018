package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;



public interface EmployeeServiceInterface {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	void createEmployee(Employee employee);

	int deleteEmployee(int id);
	
	Employee checkLogin(String username, String password);

	int getLastId();
	
	Employee getEmployeeByEmail(String emailId);

}
