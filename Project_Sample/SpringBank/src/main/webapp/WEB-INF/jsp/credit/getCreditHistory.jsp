<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Credit History</title>
	</head>
	
	
	<body>
		<h2>Credit History for Account Id ${accountholder.userId}</h2>
		
		<table border="1">
			<tr>
				<td>Credit Id</td>
				<td>Account Id</td>
				<td>Credit Amount</td>
				<td>Credit Posted Date</td>
				<td>Credit Type</td>
				<td>Balance</td>
			</tr>
			<c:forEach items="${creditListByAccountId}" var="c">
				<tr>
					<td><c:out value="${c.creditId}" /></td>
					<td><c:out value="${c.accountId}" /></td>
					<td><c:out value="${c.amount}" /></td>
					<td><c:out value="${c.postedDate}" /></td>
					<td><c:out value="${c.creditType}" /></td>
					<td><c:out value="${c.balance}" /></td>
				</tr>
			</c:forEach>
		</table>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Return Home</a>
	</body>
</html>