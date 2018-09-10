package com.metacube.training.EmployeePortal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobDAO {
	public static boolean createJob(String title) {
		String query="INSERT INTO Job(title) VALUES (?)";
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, title);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static ResultSet getAllJobs() {
		String query="SELECT * FROM Job";
		ResultSet rset=null;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			rset = statement.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rset;
	}

}
