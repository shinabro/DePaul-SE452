package edu.depaul.se.servlet;

import java. io.*;
import java. util.*;
import javax. servlet.*;
import javax. servlet. http.*;

public class HelloHTML extends HttpServlet 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bgcolor;
    private String fgcolor;

    public void init() 
    {
        bgcolor = getInitParameter("bgcolor");
        fgcolor = getInitParameter("fgcolor");
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        response.setContentType("text/html");        
        PrintWriter out = response.getWriter();
        out. println("<html>");
        out. println("<head><title>Hello Colorful World</title></head>");
        if (bgcolor != null) 
        {
            out.println("<body bgcolor=\"" + bgcolor + "\">");
        } 
        else 
        {
            out.println("<body>");
        }
        
        if (fgcolor != null) 
        {
            out.println("<h1><font color=\"" + fgcolor +
            "\"> Hello! </font></h1>");
        } else {
           out. println("<h1> Hello! </h1>");
        }
    
        out.println(" The time is <i>" + new Date() + "</i>");
        out.println("<br>");
        out.println(" The request URI is <i>" +  request.getRequestURI() + "</i>");
        out.println("</body>");
        out.println("</html>");        
    }    
}
    