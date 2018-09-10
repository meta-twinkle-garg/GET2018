package com.metacube.training.EmployeePortal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDAO {

	public static boolean createSkill(String name) {
		String query="INSERT INTO Skill(name) VALUES (?)";
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static ResultSet getAllSkills() {
		String query="SELECT * FROM Skill";
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
