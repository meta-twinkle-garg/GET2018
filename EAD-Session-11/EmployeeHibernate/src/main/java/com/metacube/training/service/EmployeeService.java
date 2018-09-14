package com.metacube.training.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;





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
	public void createEmployee(Employee employee) {
		 employeeDAO.createEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee=employeeDAO.getEmployeeById(id);
		return employeeDAO.deleteEmployee(employee);
		
	}

	@Override
	public Employee checkLogin(String username, String password) {
		return employeeDAO.checkLogin(username,password);
	}
	
	
}
