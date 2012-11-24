<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Debit History</title>
	</head>
	
	<body>
		<h2>Debit History for Account Id ${accountholder.userId}</h2>
		
		<table border="1">
			<tr>
				<td>Debit Id</td>
				<td>Account Id</td>
				<td>Debit Amount</td>
				<td>Debit Posted Date</td>
				<td>Debit Type</td>
				<td>Balance</td>
			</tr>
			<c:forEach items="${debitListByAccountId}" var="d">
				<tr>
					<td><c:out value="${d.debitId}" /></td>
					<td><c:out value="${d.accountId}" /></td>
					<td><c:out value="${d.amount}" /></td>
					<td><c:out value="${d.postedDate}" /></td>
					<td><c:out value="${d.debitType}" /></td>
					<td><c:out value="${d.balance}" /></td>
				</tr>
			</c:forEach>
		</table>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Return Home</a>
	</body>
</html>
