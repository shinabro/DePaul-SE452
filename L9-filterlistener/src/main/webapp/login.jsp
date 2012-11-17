<html>
<head>
   <title>Login</title>
   <link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>
<h1>Login</h1>
<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%>

<form method="post" action="">
   <div>
      Username: <input type="text" name="username" size="36" />

   </div>
   <div>
      Password: <input type="password" name="password" size="36" />

   </div>
   <div>
      <input type="submit" value="Login" />
   </div>

</form>
</html>