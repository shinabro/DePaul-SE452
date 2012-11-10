<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="user" scope="session" class="edu.depaul.se.bean.User"/>

<jsp:setProperty name="user" property="name" value="Mary"/>
<jsp:setProperty name="user" property="email" value="myemail@yahoo.com"/>
<jsp:setProperty name="user" property="age" value="15"/>
<h2>Forwarding</h2>
<!-- Notice the difference in the url and content between when you using jsp:include vs jsp:forward -->
<jsp:forward page="/ShowUserUsingTag.jsp" />
<h2>Included</h2>