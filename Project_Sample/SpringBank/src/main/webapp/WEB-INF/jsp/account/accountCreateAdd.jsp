<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open an Account</title>
</head>
<body>

	<h2><b>Fill in submission form to open an Account</b></h2>
	<form:form method="POST" commandName="accountCreateAddForm">
		<table>
			<tr>
				<td>What type of Account would you like to open....</td>
				<td>
					<form:select path="accountType">
						<form:options items="${accountTypes}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Enter An Initial Account Balance:</td>
				<td><form:input path="balance" /></td>
			</tr>
			<tr>
				<td>Enter An Initial Interest Rate:</td>
				<td><form:input path="interestRate" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add Account"/>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="${pageContext.request.contextPath}/index.jsp">Return Home</a>
</body>
</html>