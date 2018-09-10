package com.metacube.training.EmployeePortal.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.metacube.training.EmployeePortal.dao.ProjectDAO;
import com.metacube.training.EmployeePortal.model.Project;




public class ProjectService {


	

	public static Project getProjectById(int id) {
		
		ResultSet rset= ProjectDAO.getProjectById(id);
		Project project=new Project();
		try{
			while(rset.next()){
				project.setId(id);
				project.setName(rset.getString("name"));
				project.setDescription(rset.getString("description"));
				project.setStartDate(rset.getDate("start_date"));
				project.setEndDate(rset.getDate("end_date"));
				project.setProjectLogo(rset.getString("project_logo"));
		}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}


	public static List<Project> getAllProjects() {
		ResultSet rset= ProjectDAO.getAllProjects();
		List<Project> projects=new ArrayList<Project>();
		try {
			while(rset.next()){
				Project project=new Project();
				project.setId(rset.getInt("project_id"));
				project.setName(rset.getString("name"));
				project.setStartDate(rset.getDate("start_date"));
				project.setEndDate(rset.getDate("end_date"));
				project.setDescription(rset.getString("description"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}


	public static boolean deleteProject(int id) {
		
		return ProjectDAO.deleteProject(id);
	}


	public static boolean updateProject(Project project) {
		return ProjectDAO.updateProject(project);
	}


	public static boolean createProject(Project project) {

		return ProjectDAO.createProject(project);
	}

	
}