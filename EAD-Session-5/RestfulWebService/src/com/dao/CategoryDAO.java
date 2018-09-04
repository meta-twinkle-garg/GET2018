package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Category;

public class CategoryDAO {

	public ResultSet getAllCategories() {
		String query = "select * from category";
		ResultSet rset = null;
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			rset = stmt.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rset;
	}

	public int addCategory(String categoryName) {
		String query = "insert into Category(Category_Name) VALUES (?)";
		int rows = 0;

		try {

			Connection conn = ConnectionDAO.getConnection();

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, categoryName);
			rows = stmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rows;
	}
}
