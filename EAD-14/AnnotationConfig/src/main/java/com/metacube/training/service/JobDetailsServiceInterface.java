package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobDetails;

public interface JobDetailsServiceInterface {

	public void addJobDetails(JobDetails jobDetail);
	public void updateJobDetails(JobDetails jobDetail);
	public JobDetails getJobDetailsByEmpId(int id);
	public List<Integer> getEmployeeByProject(int id);
}
