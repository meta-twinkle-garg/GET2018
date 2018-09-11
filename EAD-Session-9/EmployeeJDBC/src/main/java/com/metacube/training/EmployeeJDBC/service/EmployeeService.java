package com.metacube.training.EmployeeJDBC.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeeJDBC.dao.EmployeeDAO;
import com.metacube.training.EmployeeJDBC.model.Employee;



@Service
public class EmployeeService implements EmployeeServiceInterface {


	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	
	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	/*@Override
	public int checkLogin(String username, String password) {
		return employeeDAO.checkLogin(username,password);
	}*/
	
	
}
