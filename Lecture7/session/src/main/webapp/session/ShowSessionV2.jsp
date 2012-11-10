<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New And Improved Session Trakker</title>
    </head>
    <body>
        <jsp:useBean id="accessCount" type="java.lang.Integer" scope="session"/>

        <%

            String heading = "Welcome new comer";

            if (accessCount > 1)
                heading = "Welcome back";
        %>
       <BODY>
       <H1 ALIGN=\"CENTER\"> <%= heading %></H1>
       <H2>Information on Your Session:</H2>
       <TABLE BORDER=1 ALIGN=\"CENTER\">
       <TR BGCOLOR=\"#FFAD00\">
       <TH>Info Type<TH>Value
       <TR>
       <TD>ID
       <TD> <%= session.getId() %>
       <TR>
       <TD>Creation Time
       <TD>
                <%= new java.util.Date(session.getCreationTime())  %>
       <TR>
                  <TD>Time of Last Access
                  <TD>
                <%= new java.util.Date(session.getLastAccessedTime()) %>
                <TR>
                  <TD>Number of Previous Accesses
                  <TD> <%= accessCount  %>
                </TABLE>
         </BODY></HTML>

<%
                accessCount = new Integer(accessCount.intValue() + 1);
                session.setAttribute("accessCount", accessCount);

%>