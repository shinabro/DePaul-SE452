package moreservlets.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.util.*; 

/** Simple filter that prints a report in the log file
 *  whenever the associated servlets or JSP pages
 *  are accessed.
 *  <P>
 *  Taken from More Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.moreservlets.com/.
 *  &copy; 2002 Marty Hall; may be freely used or adapted.
 */
@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {
  private FilterConfig config;
  private ServletContext context;
  private String filterName;
  
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest)request;
    context.log("[Filter: " + filterName + ".] " +req.getRemoteHost() +
                " tried to access " +
                req.getRequestURL() +
                " on " + new Date());
    long startTime = System.currentTimeMillis();
    chain.doFilter(request,response);
    long duration = System.currentTimeMillis() - startTime;
    context.log("[Filter: " + filterName + ".] Duration: " + duration + "ms");
  }

  public void init(FilterConfig config)
      throws ServletException {
    this.config = config; // In case it is needed by subclass.
    context = config.getServletContext();
    filterName = config.getFilterName();
  }
  
  public void destroy() {}
}
