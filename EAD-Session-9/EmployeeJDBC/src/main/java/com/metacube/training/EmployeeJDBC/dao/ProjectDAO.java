package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Project;


	public interface ProjectDAO {
		
		
		Project getProjectById(int id);

		List<Project> getAllProjects();

		boolean deleteProject(Project project);

		boolean updateProject(Project project);

		boolean createProject(Project project);
	
}
