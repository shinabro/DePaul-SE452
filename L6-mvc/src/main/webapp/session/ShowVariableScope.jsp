<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Phrase bean</title>
    </head>
    <body>
        <!--  1.  Change scope from session to page without changing the scope on the receiver -->
        <!--  2.  Change scope from session to page and make sure to change the scope on the receiver-->
        <jsp:useBean id = "greetings" scope = "session" class = "edu.depaul.se.Phrase">
            <jsp:setProperty name="greetings" property="greetings" value="Hello again, World!" />
        </jsp:useBean>
        Something before<br>
        <!--  3.  Change include to forward -->
        <jsp:include page="Receiver.jsp"/>
        <br>Something after
</html>
