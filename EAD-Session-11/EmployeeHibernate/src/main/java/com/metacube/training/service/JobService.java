package com.metacube.training.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;





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
	public void createJob(Job job) {
		jobDAO.createJob(job);
	}

	@Override
	public boolean updateJob(Job job) {
		return jobDAO.updateJob(job);
		
	}
	@Override
	public boolean deleteJob(int id){
		Job job=jobDAO.getJobById(id);
		return jobDAO.deleteJob(job);
	}

}
