package com.dao;

import java.sql.Date;

public class QueryDAO {

	public static String addUser() {
		String query = "INSERT INTO User_Details(First_name, Last_Name, DOB, Contact_Number, Email, Password, Organization) VALUES(?,?,?,?,?,?,?)";
		return query;
	}

	public static String checkUserIsPresent() {

		String query = "SELECT Email FROM User_Details WHERE Id!=?";
		return query;
	}

	public static String getPasswordByEmail() {
		String query = "SELECT * FROM User_Details WHERE Email=?";
		return query;
	}

	public static String updateUserInfo() {
		String query = "UPDATE USer_Details SET First_name=?, Last_Name=?, DOB=?, Contact_Number=?, Email=?, Organization=? WHERE Id=?";
		return query;
	}

	public static String getFriends() {
		String query = "SELECT * FROM User_Details WHERE Organization=? AND Id!=?";
		return query;
	}

	public static String getUserById() {
		String query = "SELECT * FROM User_Details WHERE Id=?";
		return query;
	}
}
