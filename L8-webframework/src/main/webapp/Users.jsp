<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/TestDB">
select id, name from users
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<TABLE BORDER=1 ALIGN=CENTER>
<TR BGCOLOR="#FFAD00">
<TH>ID<TH>Name
<c:forEach var="row" items="${rs.rows}">
		<tr>
        <td>${row.id}
        <td>${row.name}
</c:forEach>
  </table>

  </body>
</html>


