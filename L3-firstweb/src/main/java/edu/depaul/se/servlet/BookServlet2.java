package edu.depaul.se.servlet;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jdbc.BookService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserServlet2 Externalizing some of the variables
 * to configuration
 */
public class BookServlet2 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BookService dao;

    @Override
    public void init() {
        String connectionString = getInitParameter("connectionString");
        String user = getInitParameter("userName");
        String password = getInitParameter("password");

        log(connectionString);
        dao = new BookService(connectionString, user, password);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UserServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet UserServlet2 at " + request.getContextPath() + "</h1>");
        out.println("<h2>using web.xml parameter</h2>");

        for (IBook book : dao.getAllBooks()) {
            out.println("<li>");
            out.println(book);
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
