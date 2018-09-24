package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Job;

public interface JobDAO {
	public Job getJobById(int id);
	public List<Job> getAllJobs();
	public boolean createJob(Job job);
	public boolean updateJob(Job job);
	boolean deleteJob(Job job);
	
}
