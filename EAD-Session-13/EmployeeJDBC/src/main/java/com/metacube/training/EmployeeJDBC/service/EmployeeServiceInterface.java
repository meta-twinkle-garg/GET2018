package com.metacube.training.EmployeeJDBC.service;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Employee;

public interface EmployeeServiceInterface {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean deleteEmployee(int id);
	
	Employee checkLogin(String username, String password);

}
