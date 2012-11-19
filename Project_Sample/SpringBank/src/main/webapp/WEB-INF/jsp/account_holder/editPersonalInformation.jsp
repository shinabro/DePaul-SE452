<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Personal Information</title>
</head>
<body>
	<h2>Editing Personal Information for ${accountholder.firstName} ${accountholder.lastName}</h2>
	<form:form method="POST" commandName="accountholder">
			<table>
			<tr>
				<td>Title: </td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>First Name: </td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Middle Name: </td>
				<td><form:input path="middleName" /></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Mailing Address: </td>
				<td><form:input path="mailingAddress" /></td>
			</tr>
			<tr>
				<td>Mailing City: </td>
				<td><form:input path="mailingCity" /></td>
			</tr>
			<tr>
				<td>Mailing State: </td>
				<td><form:input path="mailingState" /></td>
			</tr>
			<tr>
				<td>Mailing Zip: </td>
				<td><form:input path="mailingZip" /></td>
			</tr>
			<tr>
				<td>Physical Address: </td>
				<td><form:input path="physicalAddress" /></td>
			</tr>
			<tr>
				<td>Physical City: </td>
				<td><form:input path="physicalCity" /></td>
			</tr>
			<tr>
				<td>Physical State: </td>
				<td><form:input path="physicalState" /></td>
			</tr>
			<tr>
				<td>Physical Zip: </td>
				<td><form:input path="physicalZip" /></td>
			</tr>
			<tr>
				<td>Phone Number: </td>
				<td><form:input path="userPhone" /></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><form:input path="userEmail" /></td>
			</tr>
			<tr>
				<td>Employer Name: </td>
				<td><form:input path="employerName" /></td>
			</tr>
			<tr>
				<td>Employer Phone</td>
				<td><form:input path="employerPhone" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Edit Account Holder"/>
				</td>
			</tr>
			</table>
		</form:form>
</body>
</html>