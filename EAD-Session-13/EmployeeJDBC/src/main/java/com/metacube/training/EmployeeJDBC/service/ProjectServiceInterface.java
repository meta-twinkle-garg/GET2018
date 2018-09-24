package com.metacube.training.EmployeeJDBC.service;

import java.util.List;

import com.metacube.training.EmployeeJDBC.model.Project;

public interface ProjectServiceInterface {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(int id);

	boolean updateProject(Project project);

	boolean createProject(Project project);
}
