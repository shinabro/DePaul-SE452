<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Please enter a username and password</title>
	</head>
	
	<body>
		<h2>Please add the username and password for ${accountholder.title} ${accountholder.lastName}'s account</h2>
		
		<form:form method="POST" commandName="accountHolderLogin">
			<table>
			<tr>
				<td>Username: </td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit"/>
				</td>
			</tr>
			</table>
		</form:form>
		

	</body>
</html>
