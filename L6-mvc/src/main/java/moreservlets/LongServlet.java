package moreservlets;

import java.io.*;
import java.util.zip.GZIPOutputStream;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import moreservlets.filters.CharArrayWrapper;

/** Servlet with <B>long</B> output. Used to test
 *  the effect of the compression filter of Chapter 9.
 *  <P>
 *  Taken from More Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.moreservlets.com/.
 *  &copy; 2002 Marty Hall; may be freely used or adapted.
 */


@WebServlet("/LongServlet")
public class LongServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println
      (docType +
       "<HTML>\n" +
       "<HEAD><TITLE>Long Page</TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<H1 ALIGN=\"CENTER\">Long Page</H1>\n");
    out.println(getContent());
    out.println("</BODY></HTML>");
    
    if (!isGzipSupported(request)) {
        // Invoke resource normally.
        response.setHeader("ResponseType", "not-compressed");

    } else {
        // Tell browser we are sending it gzipped data.
    	response.setHeader("Content-Encoding", "gzip");
    	response.setHeader("ResponseType", "compressed");

	    // Make a writer that compresses data and puts
	    // it into a byte array.
	    ByteArrayOutputStream byteStream =
	            new ByteArrayOutputStream();
	    GZIPOutputStream zipOut =
	            new GZIPOutputStream(byteStream);
	    OutputStreamWriter tempOut =
	            new OutputStreamWriter(zipOut);
	
	    // Compress original output and put it into byte array.
        CharArrayWrapper responseWrapper =new CharArrayWrapper(response);

        // Get character array representing output.
        char[] responseChars = responseWrapper.toCharArray();
        
        // Compress original output and put it into byte array.
        tempOut.write(responseChars);
	
	    // Gzip streams must be explicitly closed.
	    tempOut.close();
	
	    // Update the Content-Length header.
	    response.setContentLength(byteStream.size());
	
	    // Send compressed result to client.
	    OutputStream realOut = response.getOutputStream();
	    byteStream.writeTo(realOut);
    }
    
  }
  
  private String getContent() {
	  StringBuilder builder = new StringBuilder();
	  final String line = "Blah, blah, blah, blah, blah. " +
                "Yadda, yadda, yadda, yadda.";
	  for(int i=0; i<10000; i++) {
	    builder.append(line);
	  }
	  
	  return builder.toString();
	  
  }
  private boolean isGzipSupported(HttpServletRequest req) {
      String encodings =
              req.getHeader("Accept-Encoding");

      String encodeFlag = req.getParameter("encoding");
      return ((encodings != null)
              && (encodings.indexOf("gzip") != -1)
              && !"none".equals(encodeFlag));
  }
  
}
