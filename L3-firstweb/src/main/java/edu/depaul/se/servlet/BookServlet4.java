package edu.depaul.se.servlet;

import edu.depaul.se.book.IBook;
import edu.depaul.se.book.jdbc.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

;

/**
 * Servlet implementation class UserServlet4 Using server configuration rather
 * than web app configuration
 */
@WebServlet(
        urlPatterns = {"/BookServlet4"}
)
public class BookServlet4 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Connection con;

    @Override
    public void init() {
        try {
            /*
        	 * For Tomcat, need context.xml
        	 * For Tomcat in Eclipse, need server.xml
        	 * 
        	 <Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="" password="" driverClassName="org.hsqldb.jdbcDriver"
               url="jdbc:hsqldb:mem:."/>

             */
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");

            try {
                con = ds.getConnection();
            } catch (SQLException ex) {
                log("SQLError in initialization", ex);
            }

        } catch (NamingException ex) {
            log("Lookup failed in initialization", ex);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            // Step 3:  Create a statement where the SQL statement will be provided
            Statement stmt = con.createStatement();

            // Step 4:  Get the resultset from the result of executing a query
            ResultSet rs = stmt.executeQuery("select * from users");

            // Step 5:  Processing the result
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Book Servlet with jdbc reference rather than hard coding database reference</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookServlet4 at " + request.getContextPath() + "</h1>");

            while (rs.next()) {
                IBook book = map(rs);
                out.print(book);
                out.print("<p>");
            }

            out.println("</body>");
            out.println("</html>");

            // Step 6:  Closing the connection
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    private IBook map(ResultSet rs) {
        Book b = new Book();
        try {
            b.setId(rs.getLong("id"));
            b.setAuthor(rs.getString("author"));
            b.setIsbn(rs.getString("isbn"));
            b.setTitle(rs.getString("title"));
        } catch (SQLException ex) {
            log("SQLError while getting result from ResultSet", ex);
        }
        return b;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
