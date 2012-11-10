<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show User Info using EL</title>
    </head>
    <body>
        <h1> Show User info using EL</h1>
<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <td align="right">Name:</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td align="right">Age</td>
        <td>${user.age}</td>
    </tr>
</table>
    </body>
</html>
