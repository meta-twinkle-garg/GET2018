package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.HeaderParam;

public class AdvertisementDAO {
	public ResultSet getAllAdvertisements() {
		String query = "select * from Advertisement";
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

	public int addAdvertisement(String advertisementTitle, String advertisementDesc, int categoryId ) {
		String query = "insert into Advertisement(Advertisement_Title, Advertisement_Desc, Category_Id) VALUES (?,?,?)";
		int rows = 0;
		
		try {

			Connection conn = ConnectionDAO.getConnection();

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, advertisementTitle);
			stmt.setString(2,advertisementDesc);
			stmt.setInt(3, categoryId);
			rows = stmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rows;
	}

	public ResultSet getAdvertisementByCategory(int categoryId) {
		String query="SELECT * FROM Advertisement WHERE Category_Id=?";
		ResultSet rset = null;
		try {

			Connection conn = ConnectionDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, categoryId);
			rset = stmt.executeQuery();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rset;
	}

	public int updateAdvertisement(String title, String newTitle) {
		String query="UPDATE Advertisement SET Advertisement_Title=? WHERE Advertisement_Title=?";
		int rows=0;
		try {

			Connection conn = ConnectionDAO.getConnection();

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newTitle);
			stmt.setString(2,title);
			rows = stmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rows;

	}

	public int deleteAdvertisement(int id) {
		String query="DELETE FROM Advertisement WHERE Id=?";
		int rows=0;
		try {

			Connection conn = ConnectionDAO.getConnection();

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rows = stmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rows;
	}
}
