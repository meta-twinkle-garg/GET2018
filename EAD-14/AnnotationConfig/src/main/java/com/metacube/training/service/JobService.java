package com.metacube.training.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;
import com.metacube.training.repository.JobRepository;





@Service
public class JobService implements JobServiceInterface {

	@Autowired
	private JobRepository jobRepository;
	
	
	
	@Override
	public Job getJobById(int id) {
		
		return jobRepository.findOne(id);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}
	
	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public boolean updateJob(Job job) {
		jobRepository.save(job);
		return true;
		
	}
	@Override
	@Transactional
	public boolean deleteJob(int id){
		jobRepository.deleteJobById(id);
		return true;
	}

}
