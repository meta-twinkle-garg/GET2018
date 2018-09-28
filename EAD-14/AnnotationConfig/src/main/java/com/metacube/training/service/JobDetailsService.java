package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

@Service
public class JobDetailsService implements JobDetailsServiceInterface {

	@Autowired
	JobDetailsRepository jobDetailsRepository;
	@Override
	public void addJobDetails(JobDetails jobDetail) {
		jobDetailsRepository.save(jobDetail);		
	}

	@Override
	public void updateJobDetails(JobDetails jobDetail) {
		jobDetailsRepository.save(jobDetail);
		
	}
	
	@Override
	@Transactional
	public JobDetails getJobDetailsByEmpId(int id) {
		return jobDetailsRepository.getJobDetails(id);
	}

	@Override
	@Transactional
	public List<Integer> getEmployeeByProject(int id) {
		return jobDetailsRepository.getEmployeeByProject(id);
	}

}
