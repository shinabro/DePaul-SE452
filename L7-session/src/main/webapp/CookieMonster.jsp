<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie Monster</title>
    </head>
    <%
            Cookie[] cookies = request.getCookies();

            if (cookies == null) {
     %>
                <h1>What no cookies.  I was so hungry.</h1>
     <%
            } else {
      %>
                <h2>Cookies....<p>They look delicious</h2>
                <table border=1>
                <th>Name<th>value
      <%

                for (int i = 0; i < cookies.length; i++) {
       %>
                <tr><td>
                    <%= cookies[i].getName() %>
                    <td>
                    <%= cookies[i].getValue() %>
                <% } // Close out the for loop %>
           <% } // Close out the if condition %>
      </table>
</html>
