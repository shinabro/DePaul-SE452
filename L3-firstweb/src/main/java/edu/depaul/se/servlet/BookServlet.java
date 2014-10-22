package edu.depaul.se.servlet;

import edu.depaul.se.account.IAccount;
import edu.depaul.se.account.business.AccountManager;
import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jdbc.BookService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample showing calling java database call similar to just from standalone
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
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
        out.println("<title>Servlet BookServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet AccountServlet at " + request.getContextPath() + "</h1>");
        String connectionString = "jdbc:hsqldb:mem:SE452";
        String user = "";
        String password = "";

        BookService dao = new BookService(connectionString, user, password);

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
