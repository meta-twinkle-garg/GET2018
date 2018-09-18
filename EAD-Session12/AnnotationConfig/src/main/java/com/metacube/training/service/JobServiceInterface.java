package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;



public interface JobServiceInterface {

	Job getJobById(int id);

	List<Job> getAllJobs();

	void createJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(int id);

}
