package com.dao;

public class Query {

	public static String addEmployee() {
		final String query = "insert into employee(first_name,last_name,email,age) values(?,?,?,?)";
		return query;
	}

	public static String searchEmployee() {
		final String query = "select * from employee where first_name= ? AND last_name= ?";
		return query;
	}

	public static String showAllEmployee() {
		final String query = "select * from employee";
		return query;
	}

	public static String getEmployee() {
		final String query = "select * from employee where id=?";
		return query;
	}

	public static String updateEmployee() {
		final String query = "update employee set first_name=?, last_name=?, email=?, age=? where id=?";
		return query;
	}

}
