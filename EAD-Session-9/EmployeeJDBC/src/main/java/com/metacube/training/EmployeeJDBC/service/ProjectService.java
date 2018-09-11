package com.metacube.training.EmployeeJDBC.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeeJDBC.dao.ProjectDAO;
import com.metacube.training.EmployeeJDBC.model.Project;



@Service
public class ProjectService implements ProjectServiceInterface {


	@Autowired
	private ProjectDAO projectDAO;
	
	
	
	@Override
	public Project getProjectById(int id) {
		
		return projectDAO.getProjectById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	@Override
	public boolean deleteProject(int id) {
		Project project = projectDAO.getProjectById(id);
		return projectDAO.deleteProject(project);
	}
	@Override
	public boolean updateProject(Project project) {
		return projectDAO.updateProject(project);
	}

	@Override
	public boolean createProject(Project project) {
		return projectDAO.createProject(project);
	}
	
	
}