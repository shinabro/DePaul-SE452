<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Show all users</title>
    </head>
    <body>
        <sql:query var = "rs" dataSource="jdbc/TestDB">
            select * from users
        </sql:query>

        <table BORDER=1 ALIGN=CENTER>
            <tr BGCOLOR="#FFAD00"/>
            <th>Id</th><th>Name</th>
            <c:forEach var="row" items="${rs.rows}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
