package edu.depaul.se.servlet;

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

import users.dao.dataobject.User;
;

/**
 * Servlet implementation class UserServlet4
 * Using server configuration rather than web app configuration
 */
@WebServlet(
		urlPatterns = { "/UserServlet4" } 
		)
public class UserServlet4 extends HttpServlet {
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
        	Context envContext  = (Context)initContext.lookup("java:/comp/env");
        	DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
        	
            try {
                con = ds.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(UserServlet4.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NamingException ex) {
            Logger.getLogger(UserServlet4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
            out.println("<title>User Servlet with jdbc reference rather than hard coding database reference</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet4 at " + request.getContextPath() + "</h1>");

            while (rs.next()) {
                users.dao.dataobject.User user = map(rs);
                out.print(user);
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
	
    private User map (ResultSet rs) throws SQLException {
        return map(rs.getInt(1), rs.getString(2));
    }

    private User map(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
