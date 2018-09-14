package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;




public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	void createEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee checkLogin(String username, String password);


}
