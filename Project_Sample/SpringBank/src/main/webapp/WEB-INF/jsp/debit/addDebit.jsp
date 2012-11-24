<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Add Debit</title>
	</head>
	
	<body>
		<h2>Add Debit WalterVargas</h2>
		
		<form:form method="POST" commandName="addDebitForm">
			<table>
				<tr>
					<td>Please select a debit type:</td>
					<td>
						<form:select path="debitType">
							<option value="Account Transfer" label="Account Transfer"/>
							<option value="Check" label="Check"/>
							<option value="Debit Card" label="Debit Card"/>
							<option value="Bill Pay" label="Bill Pay"/>
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
						<input type="submit" value="Add Debit"/>
					</td>
				</tr>
			</table>
		</form:form>
		<br>
		<a href="${pageContext.request.contextPath}/index.jsp">Return Home</a>

	</body>
</html>
