package edu.depaul.se.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int counter=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() {
    	log("CounterServlet.init");
    	counter = 0;
    }
    
    @Override
    public void destroy() {
    	log("CounterServlet.destory");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
                
        writer.print("<h1>Hello world</h1>");
 		counter++;
        writer.print("Number of visits is <b>"+counter+"</b>");

//		log("doGet method: " + counter);
	}


}
