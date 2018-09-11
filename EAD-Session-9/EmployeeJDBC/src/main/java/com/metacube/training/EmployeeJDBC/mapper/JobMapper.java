package com.metacube.training.EmployeeJDBC.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeeJDBC.model.Job;

public class JobMapper  implements RowMapper<Job> {

	public Job mapRow(ResultSet rset, int i) throws SQLException {
		Job job=new Job();
		job.setId(rset.getInt("id"));
		job.setTitle(rset.getString("title"));
		return job;
	}
}