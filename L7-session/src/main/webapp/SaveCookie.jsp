<%@ page import="java.util.*" %>
<html>
<head>JSP Example: Temporary cookies</head>
<BODY BGCOLOR="#FDF5E6">

<%
    String name = (String) request.getParameter("name");
    String value = (String) request.getParameter("value");
    
    Cookie c = new Cookie(name, value);    
    response.addCookie(c);
%>    

Cookie Values have been saved.