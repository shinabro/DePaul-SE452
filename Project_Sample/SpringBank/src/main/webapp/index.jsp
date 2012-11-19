<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring Bank</title>
    </head>
    <body>
        <h2>Account Holder Administration</h2>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/account_holder/accountHolderRegister.htm">Add Account Holder</a></td>
            </tr>
        </table>
        <h2>User Login</h2>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/login/login.htm">Login</a></td>
            </tr>
        </table>
        <h2>Account</h2>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/account/account.htm">Add Account</a></td>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/account/showAccountInfo.htm">Account Info</a>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/account/deleteAccount.htm">Close An Account</a>
            </tr>
        </table>
        <h2>Debit</h2>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/debit/addDebit.htm">Add Debit</a></td>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/debit/getDebitList.htm">View Debit History</a></td>
            </tr>
        </table>
        <h2>Credit</h2>
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/credit/addCredit.htm">Add Credit</a></td>
            </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/credit/getCreditList.htm">Credit History</a></td>
            </tr>
        </table>
    </body>
</html>