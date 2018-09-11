package com.metacube.training.EmployeeJDBC.service;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Job;

public interface JobServiceInterface {

	Job getJobById(int id);

	List<Job> getAllJobs();

	boolean createJob(Job job);

}
