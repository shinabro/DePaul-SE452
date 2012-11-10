package moreservlets.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.util.zip.*;

/** Filter that compresses output with gzip
 *  (assuming that browser supports gzip).
 *  <P>
 *  Taken from More Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.moreservlets.com/.
 *  &copy; 2002 Marty Hall; may be freely used or adapted.
 */
@WebFilter(filterName = "CompressionFilter", urlPatterns = {"/LongServlet"})
public class CompressionFilter implements Filter {

    private FilterConfig config;
    private ServletContext context;
    private String filterName;

    /** If browser does not support gzip, invoke resource
     *  normally. If browser <I>does</I> support gzip,
     *  set the Content-Encoding response header and
     *  invoke resource with a wrapped response that
     *  collects all the output. Extract the output
     *  and write it into a gzipped byte array. Finally,
     *  write that array to the client's output stream.
     */
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (!isGzipSupported(req)) {
            // Invoke resource normally.
            res.setHeader("ResponseType", "not-compressed");
            context.log("[Filter: " + filterName + ".] content NOT compressed");
            chain.doFilter(req, res);

        } else {
            // Tell browser we are sending it gzipped data.
            res.setHeader("Content-Encoding", "gzip");
            res.setHeader("ResponseType", "compressed");

            // Invoke resource, accumulating output in the wrapper.
            CharArrayWrapper responseWrapper =
                    new CharArrayWrapper(res);
            context.log("[Filter: " + filterName + ".] content compressed");
            chain.doFilter(req, responseWrapper);

            // Get character array representing output.
            char[] responseChars = responseWrapper.toCharArray();

            // Make a writer that compresses data and puts
            // it into a byte array.
            ByteArrayOutputStream byteStream =
                    new ByteArrayOutputStream();
            GZIPOutputStream zipOut =
                    new GZIPOutputStream(byteStream);
            OutputStreamWriter tempOut =
                    new OutputStreamWriter(zipOut);

            // Compress original output and put it into byte array.
            tempOut.write(responseChars);

            // Gzip streams must be explicitly closed.
            tempOut.close();

            // Update the Content-Length header.
            res.setContentLength(byteStream.size());

            // Send compressed result to client.
            OutputStream realOut = res.getOutputStream();
            byteStream.writeTo(realOut);
        }
    }

    /** Store the FilterConfig object in case subclasses
     *  want it.
     */
    public void init(FilterConfig config)
            throws ServletException {
        this.config = config;
        context = config.getServletContext();
        filterName = config.getFilterName();
    }

    protected FilterConfig getFilterConfig() {
        return (config);
    }

    public void destroy() {
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
