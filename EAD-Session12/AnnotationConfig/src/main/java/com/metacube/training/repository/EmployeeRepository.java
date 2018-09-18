package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
	
	@Modifying
	@Query("delete from Employee where id = ?1")
	int deleteEmployeeById(int id);
	
	@Query("select e from Employee e where e.emailId=?1 AND e.password=?2")
	Employee checkLogin(String emailId, String password);

}
