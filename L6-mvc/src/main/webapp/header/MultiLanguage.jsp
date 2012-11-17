<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<html>
    <head BGCOLOR="#FDF5E6">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Multi Language</title>
    </head>
    <body>
        <h2>
        <% String language = request.getParameter("language"); %>
        But I know you like to speak <%= request.getHeader("accept-language") %> but you wanted to see greeting in <%= language %>       
        </h2>

        <li>
        	<% ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("msg", new Locale(language)); %>
        	<%= resourceBundle.getString("greeting") %>
    </body>
</html>
