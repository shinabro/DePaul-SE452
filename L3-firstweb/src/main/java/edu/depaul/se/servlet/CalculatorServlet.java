package edu.depaul.se.servlet;

import edu.depaul.se.calculator.DivideByZeroException;
import edu.depaul.se.calculator.business.Calculator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculatorServlet"})
public class CalculatorServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String lhs = request.getParameter("lhs");
            String rhs = request.getParameter("rhs");
            char operator = request.getParameter("operator").charAt(0);

            float lhsNum = 0;
            float rhsNum = 0;
            
            try {
                lhsNum = Integer.parseInt(lhs);
                rhsNum = Integer.parseInt(rhs);
            } catch (NumberFormatException nfe) {
                out.println("<html>");
                out.println("<h1>");
                out.println("One or more values were not numeric, please enter only numeric values");
                out.println("</html>");
                return;
            }
            
            StringBuilder result = new StringBuilder();

            Calculator calculator = new Calculator();
    
            if (operator == '+') {
                result.append(calculator.add(lhsNum, rhsNum));
            } else if (operator == '-') {
                result.append(calculator.subtract(lhsNum, rhsNum));
            } else if (operator == '*') {
                result.append(calculator.multiply(lhsNum, rhsNum));
            } else {
                try {
                    result.append(calculator.divide(lhsNum, rhsNum));
                } catch (DivideByZeroException ex) {
                    result.append("Divide by zero error");
                } 
            }

            String content = lhs + operator + rhs + "=" + result;

            out.println("<html>");
            out.println("<head>Calculator</head>");
            out.print("<h1>");
            out.println(content);
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
