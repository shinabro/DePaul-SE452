package edu.depaul.se.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SnoopServlet
 */
@WebServlet("/SnoopServlet")
public class SnoopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out;

		res.setContentType("text/html");
		out = res.getWriter();

		out.println("<html>");
		out.println("<head><title>Snoop Servlet</title></head>");
		out.println("<body>");

		out.println("<h1>Requested URL:</h1>");
		out.println("<pre>");
		out.println(req.getRequestURL());
		out.println("</pre>");

		Enumeration<String> initNames = getServletConfig()
				.getInitParameterNames();
		if (initNames != null) {
			boolean first = true;
			while (initNames.hasMoreElements()) {
				if (first) {
					out.println("<h1>Init Parameters</h1>");
					out.println("<pre>");
					first = false;
				}
				String param = initNames.nextElement();
				out.println(" " + param + ": " + getInitParameter(param));
			}
			out.println("</pre>");
		}

		out.println("<h1>Request information:</h1>");
		out.println("<pre>");

		print(out, "Request method", req.getMethod());
		print(out, "Request URI", req.getRequestURI());
		print(out, "Request protocol", req.getProtocol());
		print(out, "Servlet path", req.getServletPath());
		print(out, "Path info", req.getPathInfo());
		print(out, "Path translated", req.getPathTranslated());
		print(out, "Query string", req.getQueryString());
		print(out, "Content length", req.getContentLength());
		print(out, "Content type", req.getContentType());
		print(out, "Server name", req.getServerName());
		print(out, "Server port", req.getServerPort());
		print(out, "Remote user", req.getRemoteUser());
		print(out, "Remote address", req.getRemoteAddr());
		print(out, "Remote host", req.getRemoteHost());
		print(out, "Authorization scheme", req.getAuthType());

		out.println("</pre>");

		Enumeration<String> e = req.getHeaderNames();
		if (e.hasMoreElements()) {
			out.println("<h1>Request headers:</h1>");
			out.println("<pre>");
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				out.println(" " + name + ": " + req.getHeader(name));
			}
			out.println("</pre>");
		}

		e = req.getParameterNames();
		if (e.hasMoreElements()) {
			out.println("<h1>Servlet parameters (Single Value style):</h1>");
			out.println("<pre>");
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				out.println(" " + name + " = " + req.getParameter(name));
			}
			out.println("</pre>");
		}

		e = req.getParameterNames();
		if (e.hasMoreElements()) {
			out.println("<h1>Servlet parameters (Multiple Value style):</h1>");
			out.println("<pre>");
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String vals[] = (String[]) req.getParameterValues(name);
				if (vals != null) {
					out.print("<b> " + name + " = </b>");
					out.println(vals[0]);
					for (int i = 1; i < vals.length; i++)
						out.println("           " + vals[i]);
				}
				out.println("<p>");
			}
			out.println("</pre>");
		}

		out.println("<h1>Java Information:</h1>");
		out.println("<pre>");
		out.println("Java version:  " + System.getProperty("java.version"));
		out.println("Java home:  " + System.getProperty("java.home"));
		out.println("Java vendor:  " + System.getProperty("java.vendor"));
		out.println("Java class version:  "
				+ System.getProperty("java.class.version"));
		out.println("Java class path:");
		String cp = System.getProperty("java.class.path");
		out.println(cp.replace(File.pathSeparatorChar, '\n'));
		out.println("</pre>");

		out.println("</body></html>");
	}

	private void print(PrintWriter out, String name, String value) {
		out.print(" " + name + ": ");
		out.println(value == null ? "&lt;none&gt;" : value);
	}

	private void print(PrintWriter out, String name, int value) {
		out.print(" " + name + ": ");
		if (value == -1) {
			out.println("&lt;none&gt;");
		} else {
			out.println(value);
		}
	}

}
