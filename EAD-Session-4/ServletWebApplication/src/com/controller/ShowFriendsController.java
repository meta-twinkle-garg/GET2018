package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.User;

/**
 * Servlet implementation class ShowFriendsController
 */
@WebServlet("/ShowFriendsController")
public class ShowFriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOInstance;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFriendsController() {
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
		List<User> listOfFriends = userDAOInstance.getFriends(
				user.getOrganization(), user.getId());

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
				+ "<th><td>Friends</td></th>";
		for (User friend : listOfFriends) {
			html += "<tr><td><a style='color:black' href='GetProfileController?id="
					+ friend.getId()
					+ "'>"
					+ friend.getFirstName()
					+ " "
					+ friend.getLastName() + "</a></td></tr>";
		}
		html += "</table></b></div></body></html>";
		out.println(html);

	}

}
