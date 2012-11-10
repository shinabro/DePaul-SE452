package edu.depaul.se.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher jsp;

	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jsp.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		if ((userName == null) || ("badusername").equals(userName)){
			request.setAttribute("message", "Authentication failed.");
			jsp.forward(request, response);
			return;
		}

		String password = request.getParameter("password");
		if ((password == null) || !"password".equals(password)) {
			request.setAttribute("message", "Authentication failed.");
			jsp.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();		
		session.setAttribute("userId", userName);
		String url = "home.jsp";
		response.sendRedirect(url);
	}


}
