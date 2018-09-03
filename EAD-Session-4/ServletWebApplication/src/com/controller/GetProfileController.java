package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class GetProfileController
 */
@WebServlet("/GetProfileController")
public class GetProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOInstance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProfileController() {
		super();
		userDAOInstance = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		User friend = userDAOInstance.getUserById(id);
		String html = "<!Doctype html><html><head><title> Metacube Training Assignment </title>"
				+ "<link rel='stylesheet' href='CSSFile.css'></head><body ><table width='100%' cellpadding=20 id='head' >"
				+ "<tr><td><img src='html-logo.png' height='70'>"
				+ "</td><td align='right'><a href='LogoutController'>Logout  |  </a>"
				+ "Hello "
				+ user.getFirstName()
				+ " "
				+ user.getLastName()
				+ "<img src='html-logo.png' height='15'>"
				+ "</td></tr></table><hr><br><br>"
				+ "<table align='center' id='profile'>"
				+ "<tr><td colspan='2'><h1>Friend Profile</h1></td></tr><tr><td>First Name</td><td>"
				+ friend.getFirstName()
				+ "</td></tr><tr><td>Last Name</td><td>"
				+ friend.getLastName()
				+ "</td></tr><tr><td>Email</td><td>"
				+ friend.getEmail()
				+ "</td></tr><tr><td>Contact Number</td><td>"
				+ friend.getContactNumber()
				+ " </td></tr><tr><td>Date Of Birth</td><td>"
				+ friend.getDateOfBirth()
				+ "</td></tr>"
				+ "<a href='ShowFriendsController'><input type='button' value='See Friends'></a>"
				+ "</b></table></body></html>";
		out.println(html);
	}

}
