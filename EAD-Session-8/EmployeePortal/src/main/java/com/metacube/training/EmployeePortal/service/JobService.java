package com.metacube.training.EmployeePortal.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.EmployeePortal.dao.JobDAO;
import com.metacube.training.EmployeePortal.model.Job;


public class JobService {

	public static boolean createJob(Job job) {
		String title=job.getTitle();
		return JobDAO.createJob(title);
		
		
	}

	public static List<Job> getAllJobs() {
		ResultSet rset= JobDAO.getAllJobs();
		List<Job> jobs=new ArrayList<Job>();
		try {
			while(rset.next()){
				Job job=new Job();
				job.setId(rset.getInt("id"));
				job.setTitle(rset.getString("title"));
				jobs.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}

}
