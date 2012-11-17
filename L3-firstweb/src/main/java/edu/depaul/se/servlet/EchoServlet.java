package edu.depaul.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Echo Servlet</title></head>");

		out.println("<B>Will display your request</B>");
		Enumeration<String> params = request.getParameterNames();
		out.println("<body>");
		out.println("<table border=1 cellspacing=0 cellpadding=0 >");
		while (params.hasMoreElements())
		{
			String paramKey = params.nextElement();
			out.println("<tr>");
			out.print("<td>");
			out.println(paramKey);
			out.println("</td>");
			out.print("<td>");
			
			String[] results = request.getParameterValues(paramKey);
			for (int i=0; i < results.length; ++i)
			{
				out.print(results[i]);
				out.println("<p>");	
			}
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
