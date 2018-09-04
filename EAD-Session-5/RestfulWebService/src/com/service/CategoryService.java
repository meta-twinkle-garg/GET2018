package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.model.Category;
//import org.json.simple.JSONObject;
import com.dao.CategoryDAO;

@Path("/category")
public class CategoryService {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addCategory(Category categoryObject) {
		CategoryDAO categoryDAOInstance = new CategoryDAO();
		String categoryName = categoryObject.getName();
		List<Category> existingCategories = getAllCategories();
		for (Category category : existingCategories) {
			if (categoryName.equals(category.getName())) {
				return Response.status(Status.NOT_ACCEPTABLE).build();
			}
		}
		if (categoryDAOInstance.addCategory(categoryName) != 0) {

			return Response.ok("Category added successfully..!",
					MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_MODIFIED).build();
		}

	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories() {
		CategoryDAO categoryDAOInstance = new CategoryDAO();
		List<Category> listOfCategories = new ArrayList<>();
		ResultSet rset = categoryDAOInstance.getAllCategories();
		try {
			while (rset.next()) {
				Category category = new Category();
				category.setId(rset.getInt("Id"));
				category.setName(rset.getString("Category_Name"));
				listOfCategories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfCategories;
	}

}
