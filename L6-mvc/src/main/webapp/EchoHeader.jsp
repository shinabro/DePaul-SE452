<%@ page import="java.util.*" %>
<html>
<head>JSP Example: Showing Request Headers</head>
<BODY BGCOLOR="#FDF5E6">

<B>Request Method: </B> <%= request.getMethod() %> <p>
<B>Request URI: </B> <%= request.getRequestURI() %> <p>
<B>Request Protocol: </B> <%= request.getProtocol() %> <BR><BR>
<TABLE BORDER=1 ALIGN=CENTER>
<TR BGCOLOR="#FFAD00">
<TH>Header Name<TH>Header Value

<%
    Enumeration headerNames = request.getHeaderNames();
    while(headerNames.hasMoreElements()) {
      String headerName = (String)headerNames.nextElement();
 %>     
<TR><TD> <%= headerName %>
<TD> <%=request.getHeader(headerName) %>

<% } %>
</TABLE></BODY></HTML>

