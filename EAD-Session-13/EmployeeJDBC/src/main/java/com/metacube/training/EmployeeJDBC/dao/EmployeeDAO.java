package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Employee;


public interface EmployeeDAO {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee checkLogin(String username, String password);


}
