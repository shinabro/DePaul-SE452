<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Add Credit</title>
	</head>
<body>
	<h2>Add Credit</h2>
	<form:form method="POST" commandName="addCreditForm">
			<table>
				<tr>
					<td>Please select a credit type:</td>
					<td>
						<form:select path="creditType">
							<option value="Account Transfer" label="Account Transfer"/>
							<option value="Check Deposit" label="Check Deposit"/>
							<option value="Pay Roll" label="Pay Roll"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Amount: </td>
					<td><form:input path="amount" /></td>
				</tr>
				<tr>
					<td>Current Balance: </td>
					<td>${account.balance}</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Add Credit"/>
					</td>
				</tr>
			</table>
		</form:form>

		<br>
		<a href="/Banking_Group3/index.jsp">Return Home</a>
</body>
</html>