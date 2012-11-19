<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${accountholder.firstName} ${accountholder.lastName}'s Personal Home Page</title>
</head>
<body>
	<P>Welcome ${accountholder.firstName} ${accountholder.lastName} to Initech Banking</P>
	
	<table>
		<tr>
			<td><b>Accounts:</b></td>		
		</tr>
		<c:forEach items="${accountsList}" var="account">
			<tr>
				<td>
				<form action="/Banking_Group3/user_home/viewAccount.htm" method="post">
					<input type="hidden" name="accountId" value="${account.accountId}">
					Account: ${account.accountId}
					<input type="submit" value="View">
				</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
		</tr>
	</table>
	
	
	<table>
		<tr>
			<td><b>Account Holder Options</b></td>
		</tr>
		<tr>
			<td><a href="/Banking_Group3/account_holder/addOtherBankAccount.htm">Link Account From Another Bank</a></td>
		</tr>
		<tr>
			<td><a href="/Banking_Group3/account_holder/editPersonalInformation.htm">Edit Personal Information</a></td>
		</tr>
		<tr>
			<td><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></td>
		</tr>
	</table>
</body>
</html>