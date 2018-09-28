package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Integer>  {

	@Query("select j from JobDetails j where j.empId=?1")
	JobDetails getJobDetails(int id);

	@Query("select empId from JobDetails where projectId=?1")
	List<Integer> getEmployeeByProject(int id);

}
