package edu.depaul.se.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = {"/greenServlet"}, 
                initParams={ @WebInitParam(name="bgcolor", value="green"), 
                             @WebInitParam(name="fgcolor", value="white") 
                }
)
public class HelloHTML extends HttpServlet {
    private String bgcolor;
    private String fgcolor;

    @Override
    public void init() {
        bgcolor = getInitParameter("bgcolor");
        fgcolor = getInitParameter("fgcolor");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Hello Colorful World</title></head>");
        if (bgcolor != null) {
            out.println("<body bgcolor=\"" + bgcolor + "\">");
        } else {
            out.println("<body>");
        }

        if (fgcolor != null) {
            out.println("<h1><font color=\"" + fgcolor
                    + "\"> Hello! </font></h1>");
        } else {
            out.println("<h1> Hello! </h1>");
        }

        out.println(" The time is <i>" + new Date() + "</i>");
        out.println("<br>");
        out.println(" The request URI is <i>" + request.getRequestURI() + "</i>");
        out.println("</body>");
        out.println("</html>");
    }
}
