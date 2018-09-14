package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;



public interface ProjectServiceInterface {

	Project getProjectById(int id);

	List<Project> getAllProjects();

	boolean deleteProject(int id);

	boolean updateProject(Project project);

	void createProject(Project project);
}
