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
 * Servlet implementation class UserServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
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
        out.println("<title>Servlet AccountServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet AccountServlet at " + request.getContextPath() + "</h1>");

        AccountManager accountManager = new AccountManager();
        for (IAccount account : accountManager.getAccountList()) {
            out.println("<li>");
            out.println(account);
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
