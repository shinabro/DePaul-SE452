<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Bank Account From Another Institution</title>
</head>
<body>
	<P>You are adding an additional bank account for ${accountholder.firstName} ${accountholder.lastName} with user id of ${accountholder.userId}</P>
	<form:form method="POST" modelAttribute="otherBankAccount">
		<table>
			<tr>
				<td>Bank Name: </td>
				<td><form:input path="bankName" /></td>
			</tr>
			<tr>
				<td>Bank Address: </td>
				<td><form:input path="bankAddress" /></td>
			</tr>
			<tr>
				<td>Account Number: </td>
				<td><form:input path="accountNumber" /></td>
			</tr>
			<tr>
				<td>Routing Number: </td>
				<td><form:input path="bankRoutingNumber" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add Other Bank Account"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>