package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operations;
import com.model.Employee;

/**
 * Servlet implementation class updateEmployee
 */
public class updateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Operations object;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateEmployee() {
		super();
		object = new Operations();
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
		Employee employee = object.searchEmployee(id);
		out.println("<form action=update method='get'>");
		out.println("<table><tr><td>First Name</td>");

		out.println("<td><input type='text' name='firstName' value='"
				+ employee.getFirstName() + "'></td>");
		out.println("</tr><tr><td>Last Name</td><td><input type='text' name='lastName' value='"
				+ employee.getLastName() + "'></td>");
		out.println("</tr><tr><td>Email</td><td><input type='text' name='email' value='"
				+ employee.getEmail() + "'></td>");
		out.println("</tr><tr><td>Age</td><td><input type='text' name='age' value='"
				+ employee.getAge() + "'></td></tr>");
		out.println("<tr><td colspan='2' align='center'><input type='submit' value='submit'></td></tr>");
		out.println("</table><input type='hidden' name='id' value='" + id
				+ "'></form>");

	}

}
