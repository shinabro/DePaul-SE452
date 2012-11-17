package edu.depaul.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.IUser;
import users.UserPersistenceException;
import users.dao.JDBCDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UserServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet UserServlet at " + request.getContextPath () + "</h1>");

        JDBCDAO dao = new JDBCDAO();
        try {
			for (IUser user : dao.getUsers()) {  
			    out.println("<li>");
			    out.println(user);
			}
		} catch (UserPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        out.println("</body>");
        out.println("</html>");

        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
