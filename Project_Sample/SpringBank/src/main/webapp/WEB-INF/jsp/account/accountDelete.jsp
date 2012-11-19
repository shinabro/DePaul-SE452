<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Account</title>
</head>
<body>

	<h2>Close Account for ${accountholder.firstName} ${accountholder.lastName}</h2>
	<form:form method="POST" commandName="accountDeleteForm">
		<table>
			<tr>
				<td>Choose an account to close</td>
			</tr>
			<tr>
				<td>  
					<form:select path="accountId">
						<form:options items="${acctList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Delete Account"/>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>