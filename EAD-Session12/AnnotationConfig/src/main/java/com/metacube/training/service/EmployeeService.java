package com.metacube.training.service;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;





@Service
public class EmployeeService implements EmployeeServiceInterface {


	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public int deleteEmployee(int id) {
		return employeeRepository.deleteEmployeeById(id);
		 
		
	}

	@Override
	public Employee checkLogin(String username, String password) {
		return employeeRepository.checkLogin(username,password);
	}
	
	
}
