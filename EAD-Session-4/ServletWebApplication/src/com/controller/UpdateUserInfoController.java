package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.QueryDAO;
import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class UpdateUserInfoController
 */
@WebServlet("/UpdateUserInfoController")
public class UpdateUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOInstance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserInfoController() {
		super();
		userDAOInstance = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String contactNumber = request.getParameter("contact");
		String organization = request.getParameter("organization");
		boolean result = userDAOInstance.updateUser(firstName, lastName, email,
				dob, contactNumber, organization, user.getId());
		if (result) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setContactNumber(contactNumber);
			user.setDateOfBirth(dob);
			user.setEmail(email);
			user.setOrganization(organization);
			response.sendRedirect("EditUserInfoController");
		} else {
			out.println("Email already exists..!!");
		}

	}

}
