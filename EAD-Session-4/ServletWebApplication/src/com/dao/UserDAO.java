package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserDAO {

	public String addUser() {
		String message = "";
		return message;
	}

	public boolean addUser(String firstName, String lastName, Date dateOfBirth,
			String contactNumber, String email, String password,
			String organization) {
		boolean result = false;
		String query = QueryDAO.addUser();
		String queryToVerify = QueryDAO.checkUserIsPresent();
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(queryToVerify);
			statement.setInt(1, 0);
			ResultSet rset = statement.executeQuery();
			if (!rset.next()) {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setDate(3, dateOfBirth);
				stmt.setString(4, contactNumber);
				stmt.setString(5, email);
				stmt.setString(6, password);
				stmt.setString(7, organization);
				stmt.executeUpdate();
				result = true;
			} else {
				do {
					if (email.equals(rset.getString("Email"))) {
						result = false;
						break;
					} else {
						PreparedStatement stmt = conn.prepareStatement(query);
						stmt.setString(1, firstName);
						stmt.setString(2, lastName);
						stmt.setDate(3, dateOfBirth);
						stmt.setString(4, contactNumber);
						stmt.setString(5, email);
						stmt.setString(6, password);
						stmt.setString(7, organization);
						stmt.executeUpdate();
						result = true;
					}
				} while (rset.next());
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public User userLogin(String email, String password) {
		User user = new User();
		String query = QueryDAO.getPasswordByEmail();
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rset = statement.executeQuery();
			if (rset.next()) {
				String actualPassword = rset.getString("Password");
				if (password.equals(actualPassword)) {
					user.setId(rset.getInt("Id"));
					user.setFirstName(rset.getString("First_Name"));
					user.setLastName(rset.getString("Last_Name"));
					user.setEmail(rset.getString("Email"));
					user.setContactNumber(rset.getString("Contact_Number"));
					user.setDateOfBirth(rset.getDate("DOB"));
					user.setPassword(actualPassword);
					user.setOrganization(rset.getString("Organization"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;

	}

	public boolean updateUser(String firstName, String lastName, String email,
			Date dob, String contactNumber, String organization, int id) {
		boolean result = false;
		String query = QueryDAO.updateUserInfo();
		String queryToVerify = QueryDAO.checkUserIsPresent();
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(queryToVerify);
			statement.setInt(1, id);
			ResultSet rset = statement.executeQuery();
			if (!rset.next()) {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				stmt.setDate(3, dob);
				stmt.setString(4, contactNumber);
				stmt.setString(5, email);
				stmt.setString(6, organization);
				stmt.setInt(7, id);
				stmt.executeUpdate();
				result = true;
			} else {
				do {
					if (email.equals(rset.getString("Email"))) {
						result = false;
						break;
					} else {
						PreparedStatement stmt = conn.prepareStatement(query);
						stmt.setString(1, firstName);
						stmt.setString(2, lastName);
						stmt.setDate(3, dob);
						stmt.setString(4, contactNumber);
						stmt.setString(5, email);
						stmt.setString(6, organization);
						stmt.setInt(7, id);
						stmt.executeUpdate();
						result = true;
					}
				} while (rset.next());
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public List<User> getFriends(String organization, int id) {
		List<User> listOfFriends = new ArrayList<>();
		String query = QueryDAO.getFriends();
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, organization);
			statement.setInt(2, id);
			ResultSet rset = statement.executeQuery();
			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt("Id"));
				user.setFirstName(rset.getString("First_Name"));
				user.setLastName(rset.getString("Last_Name"));
				user.setEmail(rset.getString("Email"));
				user.setDateOfBirth(rset.getDate("dob"));
				user.setContactNumber(rset.getString("Contact_Number"));
				listOfFriends.add(user);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listOfFriends;
	}

	public User getUserById(int id) {
		User friend = new User();
		String query = QueryDAO.getUserById();
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rset = statement.executeQuery();
			while (rset.next()) {
				friend.setId(rset.getInt("Id"));
				friend.setFirstName(rset.getString("First_Name"));
				friend.setLastName(rset.getString("Last_Name"));
				friend.setEmail(rset.getString("Email"));
				friend.setDateOfBirth(rset.getDate("dob"));
				friend.setContactNumber(rset.getString("Contact_Number"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return friend;
	}
}