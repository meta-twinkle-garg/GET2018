package com.dao;

import com.model.Employee;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Operations {

	public String addEmployee(String firstName, String lastName, String email,
			int age) {

		String query = Query.addEmployee();
		String message = "";
		String queryToVerify = "select email from employee";
		try {

			Connection conn = Connectivity.getConnection();
			PreparedStatement statement = conn.prepareStatement(queryToVerify);
			ResultSet rset = statement.executeQuery();

			while (rset.next()) {
				if (email.equals(rset.getString("email"))) {
					message = "User already exists..!!";
					break;
				} else {
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setString(1, firstName);
					stmt.setString(2, lastName);
					stmt.setString(3, email);
					stmt.setInt(4, age);
					stmt.executeUpdate();
					message = "User added successfully..!!";
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return message;
	}

	public List<Employee> searchEmployee(String firstName, String lastName) {
		List<Employee> listOfEmployee = new ArrayList<>();
		String query = Query.searchEmployee();
		try {

			Connection conn = Connectivity.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				listOfEmployee.add(new Employee(rset.getString("first_name"),
						rset.getString("last_name"), rset.getString("email"),
						rset.getInt("age"), rset.getInt("id")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listOfEmployee;
	}

	public List<Employee> showAllEmployee() {
		List<Employee> listOfEmployee = new ArrayList<>();
		String query = Query.showAllEmployee();
		try {

			Connection conn = Connectivity.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				listOfEmployee.add(new Employee(rset.getString("first_name"),
						rset.getString("last_name"), rset.getString("email"),
						rset.getInt("age"), rset.getInt("id")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return listOfEmployee;
	}

	public Employee searchEmployee(int id) {
		String query = Query.getEmployee();
		Employee employee = new Employee();
		try {

			Connection conn = Connectivity.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				employee.setFirstName(rset.getString("first_name"));
				employee.setLastName(rset.getString("last_name"));
				employee.setEmail(rset.getString("email"));
				employee.setAge(rset.getInt("age"));
				employee.setId(id);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return employee;

	}

	public String updateEmployee(String first, String last, String email,
			int age, int id) {
		String message = "";
		String queryToVerify = "select email from employee where id!=?";
		try {

			Connection conn = Connectivity.getConnection();
			PreparedStatement statement = conn.prepareStatement(queryToVerify);
			statement.setInt(1, id);
			ResultSet rset = statement.executeQuery();

			while (rset.next()) {
				if (email.equals(rset.getString("email"))) {
					message = "User already exists..!!";
					break;
				} else {
					String query = Query.updateEmployee();
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setString(1, first);
					stmt.setString(2, last);
					stmt.setString(3, email);
					stmt.setInt(4, age);
					stmt.setInt(5, id);
					stmt.executeUpdate();
					message = "Updation done successfully..!!";
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return message;
	}

}