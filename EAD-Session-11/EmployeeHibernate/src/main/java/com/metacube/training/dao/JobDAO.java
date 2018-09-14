package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;



public interface JobDAO {
	public Job getJobById(int id);
	public List<Job> getAllJobs();
	public void createJob(Job job);
	public boolean updateJob(Job job);
	boolean deleteJob(Job job);
	
}
