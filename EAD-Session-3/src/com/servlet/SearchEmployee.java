package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operations;
import com.model.Employee;

/**
 * Servlet implementation class SearchEmployee
 */

public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Operations object;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployee() {
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
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		List<Employee> listOfEmployee = object.searchEmployee(first, last);
		PrintWriter out = response.getWriter();
		int count = 1;
		for (Employee employee : listOfEmployee) {
			out.println("" + count + ":" + "<br>");
			out.println("Id: " + employee.getId() + "<br>");
			out.println("First-Name: " + employee.getFirstName() + "<br>");
			out.println("Last-Name: " + employee.getLastName() + "<br>");
			out.println("Email: " + employee.getEmail() + "<br>");
			out.println("Age: " + employee.getAge() + "<br>");
			count++;
		}
	}

}
