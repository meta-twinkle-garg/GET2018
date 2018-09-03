package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO UserDAOInstance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		UserDAOInstance = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String organization = request.getParameter("organization");
		Date dateOfBirth = Date.valueOf(request.getParameter("dob"));
		String contactNumber = request.getParameter("contact");
		boolean result = UserDAOInstance.addUser(first, last, dateOfBirth,
				contactNumber, email, password, organization);
		PrintWriter out = response.getWriter();
		if (result) {
			response.sendRedirect("login.html");
		} else {
			out.print("User already esists..!!");
		}

	}

}
