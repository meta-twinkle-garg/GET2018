package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeeJDBC.mapper.JobMapper;
import com.metacube.training.EmployeeJDBC.model.Job;

@Repository
public class JobDAOImpl implements JobDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_JOB = "select * from job where id = ?";
	private final String SQL_GET_ALL = "select * from job";
	private final String SQL_INSERT_JOB = "insert into job(title) values(?)";

	public Job getJobById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_JOB, new Object[] { id }, new JobMapper());
	}

	public List<Job> getAllJobs() {
		return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
	}

	public boolean createJob(Job job) {
		return jdbcTemplate.update(SQL_INSERT_JOB, job.getTitle()) > 0;
	}
}
