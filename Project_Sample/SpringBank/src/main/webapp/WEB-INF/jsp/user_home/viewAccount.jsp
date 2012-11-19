<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Information</title>
</head>
<body>
	<b>Account: </b>${account.accountId}
	<br>
	<b>Account Type: </b>${account.accountType}
	<br>
	<b>Balance: </b>${account.balance}
	<br>
	<b>Interest Rate: </b>${account.interestRate}
	<br>
	<b>Credits:</b>
	<table>
		<c:forEach items="${creditsList}" var="credit">
			<tr>
				<td><b>Posting Date:</b> ${credit.postedDate}</td>
				<td><b>Amount:</b> ${credit.amount}</td>
				<td><b>Balance After:</b> ${credit.balance}</td>
			</tr>
		</c:forEach>
	</table>
	<b>Debits:</b>
	<table>
		<c:forEach items="${debitsList}" var="debit">
			<tr>
				<td><b>Posting Date:</b> ${debit.postedDate}</td>
				<td><b>Amount:</b> ${debit.amount}</td>
				<td><b>Balance After:</b> ${debit.balance}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>