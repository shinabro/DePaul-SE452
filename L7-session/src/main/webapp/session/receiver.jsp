<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:useBean id = "greetings" scope = "session" class = "edu.depaul.se.Phrase"/>
<li>Using Expression: <%= greetings.getGreetings() %>
<br>
<li>Using EL:  ${greetings.greetings}
<br>
<li>Using Tag: <jsp:getProperty name="greetings" property="greetings"/>
</body>
</html>