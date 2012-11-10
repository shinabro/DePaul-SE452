package edu.depaul.se.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.misc.BASE64Decoder;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/secure/*")
public class SecurityFilter implements Filter {
	private ServletContext context;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		context = filterConfig.getServletContext();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();

        String authorization = req.getHeader("Authorization");
        if (authorization != null) {
            String userInfo = authorization.substring(6).trim();
            BASE64Decoder decoder = new BASE64Decoder();
            String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            
            if (user != null) {
				// User is logged in.
				context.log("authorized security: welcome [" + user +"]");
				chain.doFilter(req, resp);
				return;
            }

		}

		// Request is not authorized.
		context.log("security login");
		askForPassword(resp);
	}
	
    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED); // Ie 401
        response.setHeader("WWW-Authenticate",
        "BASIC realm=\"privileged-few\"");
    }
}
