<%@ page import="java.util.*" %>

<html>
    <head><title>Echo JSP</title></head>

    <B>Will display your request</B>

    <body>
        <table border=1 cellspacing=0 cellpadding=0 >
    		
    		<%
    		Enumeration params = request.getParameterNames();
    		while (params.hasMoreElements())
    		{
    			String paramKey = (String) params.nextElement();
    		%>	
    			<tr>
    			<td>
    			<%= paramKey %>
    			</td>
    			<td>
    		<%	
    			String[] results = request.getParameterValues(paramKey);
    			for (int i=0; i < results.length; ++i)
    			{
    				out.print(results[i]);
    		%>		
    				<p>
    		<%		
    			}   // Closing the for loop
    		%>	
    			</td>
    			</tr>
    		<%
    		}   // Closing the while loop
    		%>	
    			
        </table>
    </body>
</html>
