package com.metacube.training.EmployeePortal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

	public static ResultSet getEmployeeById(int id) {
		String query="SELECT * FROM employee WHERE emp_code=?";
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

	public static boolean createEmployee(String firstName, String emailId, String gender, Date dob) {
		String query="INSERT INTO employee(first_name, email_id, gender, dob) VALUES(?,?,?,?) ";
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, emailId);
			statement.setString(3, gender);
			statement.setDate(4, dob);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static boolean updateEmployee(String firstName, String lastName,
			String skypeId, String primary, String secondary, Date dob,
			String profilePicture, String gender, String password, int id) {
		String query="UPDATE employee SET firsT_name=?, last_name=?, skype_id=?, primary_contact_no=?"
				+ "secondary_contact_no=? profile_picture=?, dob=?, gender=?, password=? WHERE id=?";
		int result=0;
		try {

			Connection conn = ConnectivityDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, skypeId);
			statement.setString(4, primary);
			statement.setString(5, secondary);
			statement.setDate(7, dob);
			statement.setString(6, profilePicture);
			statement.setString(8, gender);
			statement.setString(9, password);
			statement.setInt(10, id);
			result = statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(result==1){
			return true;
		}
		return false;
	}

	public static ResultSet getAllEmployee() {
		String query="SELECT * FROM employee";
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

	public static ResultSet checkLogin(String username, String password) {
		String query="SELECT id FROM employee WHERE email=? AND password=?";
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

}
