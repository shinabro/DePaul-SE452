<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Basic JSTL</title>
    </head>
    <body>
<TABLE BORDER=1 ALIGN=CENTER>
<TR BGCOLOR="#FFAD00">
<th>Value</th>
    <th>Square</th><th>Is even</th></tr>
<c:forEach var="x" begin="1" end="10" step="1">
  <tr><td><c:out value="${x}"/></td>
      <td><c:out value="${x * x}"/></td>
	  <td><c:if test="${x%2 == 0}">
		     <p>Y</p>
	      </c:if>
  </tr>
</c:forEach>
</table>

    </body>
</html>
