<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Account Information</title>
	</head>
	
	<body>
		<h2>Account Information for ${accountholder.firstName} ${accountholder.lastName}</h2>
		
		<table border="1">
			<tr>
				<td>Account ID</td>
				<td>Account Type</td>
				<td>Balance</td>
				<td>Interest Rate</td>
			</tr>
			<c:forEach items="${acctList}" var="d">
				<tr>
					<td><c:out value="${d.accountId}" /></td>
					<td><c:out value="${d.accountType}" /></td>
					<td><c:out value="${d.balance}" /></td>
					<td><c:out value="${d.interestRate}" /></td>
				</tr>
			</c:forEach>
		</table>
	<br>
	<a href="/Banking_Group3/index.jsp">Return Home</a>
	</body>
</html>