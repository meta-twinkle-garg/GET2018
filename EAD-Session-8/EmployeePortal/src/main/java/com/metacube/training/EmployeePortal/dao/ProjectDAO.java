package com.metacube.training.EmployeePortal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.metacube.training.EmployeePortal.model.Project;

public class ProjectDAO {

	public static ResultSet getProjectById(int id) {
		String query = "SELECT * FROM project WHERE project_id=?";
		ResultSet rset = null;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,id);
			rset = statement.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rset;
	}

	public static ResultSet getAllProjects() {
		String query = "SELECT * FROM project";
		ResultSet rset = null;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			rset = statement.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rset;
	}

	public static boolean deleteProject(int id) {
		int result=0;
		String query="DELETE FROM project WHERE project_id=?";
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,id);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static boolean updateProject(Project project) {
		String query="UPDATE project SET name=? description=?, start_date=?,"
				+ "end_date=?, project_logo=? WHERE project_id=?";
		int id=project.getId();
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2,project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setString(5, project.getProjectLogo());
			statement.setInt(6, id);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static boolean createProject(Project project) {
		String query="INSERT INTO project(name, description, start_date,"
				+ " end_date, project_logo) VALUES(?,?,?,?,?)";
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2,project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setString(5, project.getProjectLogo());
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

}
