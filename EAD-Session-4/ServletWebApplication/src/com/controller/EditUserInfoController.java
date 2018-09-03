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
 * Servlet implementation class EditUserInfoController
 */
@WebServlet("/EditUserInfoController")
public class EditUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOInstance = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserInfoController() {
		super();

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
				+ "<form id= 'formSignUp' action=UpdateUserInfoController onsubmit='return validateForm()' method='get>"
				+ "<table align='center' id='Edit'>"
				+ "<tr><td> First Name</td><td> <input type='text' id='firstName' name='firstName' value='"
				+ user.getFirstName()
				+ "'> </td></tr><tr><td> Last Name</td><td> "
				+ "<input type='text' id='lastName' name='lastName' value='"
				+ user.getLastName()
				+ "'> </td></tr><tr><td> Email</td><td>"
				+ " <input type='text' name='email' id='email' value='"
				+ user.getEmail()
				+ "'> </td>"
				+ "</tr><tr><td> Date Of Birth</td><td>"
				+ " <input type='date' name='dob' id='dob' value='"
				+ user.getDateOfBirth()
				+ "'> </td>"
				+ "<tr><td> Contact Number</td><td> <input type='text' id='contact'"
				+ " name='contact' value='"
				+ user.getContactNumber()
				+ "'> </td>"
				+ "</tr><tr><td> Organization </td>"
				+ "<td> <select name='organization' id='organization' value='"
				+ user.getOrganization()
				+ "'"
				+ "><option value='Metacube'>Metacube</option><option value='SKIT'>SKIT</option>"
				+ "<option value='JECRC'> JECRC </option><option value='Arya College'> Arya College</option>"
				+ "</select></td></tr><tr ><td colspan='2' align='center'> <input type='submit' value='submit'></td>"
				+ "</tr></table></form></form></body></html>";
		out.println(html);

	}
}
