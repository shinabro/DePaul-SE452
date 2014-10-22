<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/TestDB">
    select isbn, author, title from book
</sql:query>

<html>
    <head>
        <title>Showing DB Content from JSP</title>
    </head>
    <body>

        <h2>Look ma no Java Code</h2>

        <TABLE BORDER=1 ALIGN=CENTER>
            <TR BGCOLOR="#FFAD00">
                <TH>ID<TH>Name<TH>Title
                    <c:forEach var="row" items="${rs.rows}">
                <tr>
                    <td>${row.isbn}
                    <td>${row.author}
                    <td>${row.title}
                    </c:forEach>
        </table>

    </body>
</html>


