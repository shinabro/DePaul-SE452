package edu.depaul.se.servlet;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.IBookService;
import edu.depaul.se.book.jdbc.BookService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet3 Similar to UserServlet2 except the
 * parameters are on annotation rather than web.xml
 */
@WebServlet(
        urlPatterns = {"/BookServlet3"},
        //				@WebInitParam(name = "connectionString", value = "jdbc:hsqldb:hsql://localhost/mydb"), 
        initParams = {
            @WebInitParam(name = "connectionString", value = "jdbc:hsqldb:mem:."),
            @WebInitParam(name = "userName", value = ""),
            @WebInitParam(name = "password", value = "")
        })
public class BookServlet3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private IBookService dao;

    @Override
    public void init() {
        String connectionString = getInitParameter("connectionString");
        String user = getInitParameter("userName");
        String password = getInitParameter("password");

        dao = new BookService(connectionString, user, password);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UserServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet UserServlet3 at " + request.getContextPath() + "</h1>");
        out.println("<h2>using annotation parameter</h2>");

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
