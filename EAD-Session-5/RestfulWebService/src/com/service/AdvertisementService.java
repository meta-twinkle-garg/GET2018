package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONObject;

import com.dao.AdvertisementDAO;
import com.model.Advertisement;

@Path("/advertisement")
public class AdvertisementService {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addAdvertisement(Advertisement AdvertisementObject,@HeaderParam("authorization") String authString) {
		if(!"get-2018".equals(authString)){
			return Response.status(Status.UNAUTHORIZED).entity("Incorrect Key").build();
		}
		AdvertisementDAO AdvertisementDAOInstance = new AdvertisementDAO();
		String advertisementTitle = AdvertisementObject.getTitle();
		String advertisementDesc=AdvertisementObject.getDescription();
		int categoryId=AdvertisementObject.getCategoryId();
		System.out.println(""+categoryId);
		if (AdvertisementDAOInstance.addAdvertisement(advertisementTitle,advertisementDesc,categoryId) != 0) {

			return Response.ok("Advertisement added successfully..!",
					MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_MODIFIED).build();
		}

	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAllAdvertisements() {
		
		AdvertisementDAO AdvertisementDAOInstance = new AdvertisementDAO();
		List<Advertisement> listOfAdvertisements = new ArrayList<>();
		ResultSet rset = AdvertisementDAOInstance.getAllAdvertisements();
		try {
			while (rset.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(rset.getInt("Id"));
				advertisement.setTitle(rset.getString("Advertisement_Title"));
				advertisement.setDescription(rset.getString("Advertisement_Desc"));
				advertisement.setCategoryId(rset.getInt("Category_Id"));
				listOfAdvertisements.add(advertisement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfAdvertisements;
	}
	
	@PUT
	@Path("/update/{title}/{newTitle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateAdvertisementByTitle(@PathParam("title") String title,@PathParam("newTitle") String newTitle,@HeaderParam("auth") String authString){
		if(!("get-2018".equals(authString))){
			return Response.status(Status.UNAUTHORIZED).entity("Incorrect Key").build();
		}
		AdvertisementDAO AdvertisementDAOInstance = new AdvertisementDAO();
		if(AdvertisementDAOInstance.updateAdvertisement(title,newTitle)!=0){
			return Response.ok("Advertisement updated successfully..!",
					MediaType.APPLICATION_JSON).build();
		}else{
			return Response.status(Status.NOT_MODIFIED).build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteAdvertisementById(@PathParam("id") int id,@HeaderParam("auth") String authString){
		if(!("get-2018".equals(authString))){
			return Response.status(Status.UNAUTHORIZED).entity("Incorrect Key").build();
		}
		AdvertisementDAO AdvertisementDAOInstance = new AdvertisementDAO();
		if(AdvertisementDAOInstance.deleteAdvertisement(id)!=0){
			return Response.ok("Advertisement deleted successfully..!",
					MediaType.APPLICATION_JSON).build();
		}else{
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
