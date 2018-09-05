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
 * Servlet implementation class LogInController
 */
@WebServlet("/LogInController")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOInstance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInController() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userDAOInstance.userLogin(email, password);
		if (user.getId() == 0) {
			out.println("Invalid email or password..!!!");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String html = "<!Doctype html><html><head><title> Metacube Training Assignment </title>"
					+ "<link rel='stylesheet' href='CSSFile.css'></head><body ><table width='100%' cellpadding=20 id='head' >"
					+ "<tr><td><img src='html-logo.png' height='70'>"
					+ "</td><td align='right'><a href='LogoutController'>Logout  |  </a>"
					+ "Hello "
					+ user.getFirstName()
					+ " "
					+ user.getLastName()
					+ "<img src=' C:/Users/User21/JavaEEWorkspace/ServletWebApplication/images/";
					if(user.getImage()==null){
						html+="html-logo.png'";
					}else{
						html+=user.getImage();
					}
					html+= " height='15'><form action=ImageUploadController method='post' "
							+"enctype='multipart/form-data'></input type='file' name='file' id='file'>" 
							+"<form></td></tr></table><hr><br><br>"
					+ "<table align='center' id='profile'>"
					+ "<tr><td colspan='2'><h1>User Profile</h1></td></tr><tr><td>First Name</td><td>"
					+ user.getFirstName()
					+ "</td></tr><tr><td>Last Name</td><td>"
					+ user.getLastName()
					+ "</td></tr><tr><td>Email</td><td>"
					+ user.getEmail()
					+ "</td></tr><tr><td>Contact Number</td><td>"
					+ user.getContactNumber()
					+ " </td></tr><tr><td>Date Of Birth</td><td>"
					+ user.getDateOfBirth()
					+ "</td></tr>"
					+ "<a href='EditUserInfoController'><input type='button' value='Edit'></a>"
					+ "<a href='ShowFriendsController'><input type='button' value='See Friends'></a>"
					+ "</b></table></body></html>";
			out.println(html);
		}
	}

}
