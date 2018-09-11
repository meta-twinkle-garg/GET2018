package com.metacube.training.EmployeeJDBC.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeeJDBC.dao.JobDAO;
import com.metacube.training.EmployeeJDBC.model.Job;



@Service
public class JobService implements JobServiceInterface {

	@Autowired
	private JobDAO jobDAO;
	
	
	
	@Override
	public Job getJobById(int id) {
		
		return jobDAO.getJobById(id);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}
	
	@Override
	public boolean createJob(Job job) {
		return jobDAO.createJob(job);
	}

}
