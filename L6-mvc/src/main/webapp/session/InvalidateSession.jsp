<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Invalidate</title>
    </head>
    <body>
        <%
            session.invalidate();
        %>
        <h1>Your session has been cleaned</h1>
    </body>
</html>
