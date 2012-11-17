<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show User Info</title>
    </head>
    <body>
        <h1>Show User info using Tag</h1>
<jsp:useBean id="user" scope="session" class="edu.depaul.se.bean.User"/>
<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <td align="right">Name:</td>
        <td><jsp:getProperty name="user"
             property="name"/></td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td><jsp:getProperty name="user"
             property="email"/></td>
    </tr>
    <tr>
        <td align="right">Age:</td>
        <td><jsp:getProperty name="user"
             property="age"/></td>
    </tr>
</table>
    </body>
</html>
