<%-- 
    Document   : ExamType_controller
    Created on : Dec 21, 2019, 8:46:21 PM
    Author     : Noha
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
		
		
			
		<%
		String ADD=request.getParameter("add");
		String UPDATE=request.getParameter("update");
		String DELETE=request.getParameter("delete");	
		
			if ((ADD != null) || (UPDATE != null) || (DELETE != null) ) 
			{
				if(ADD != null)
				{
					%>
					<form action="ExamType_controller2" method="get">
						<input type="text" name="newAdd">
						<input type="submit" value="Add" >
					</form>
					<%
					
				}
				else if (UPDATE != null)
				{
					%>
					<form action="ExamType_controller2" method="get">
						Enter Exam type you want to update
						<input type="text" name="oldUpdate">
						<br><br>
						Enter new Exam type
						<input type="text" name="newUpdate">

						<input type="submit" value="Update" >
					</form>
					<%
				}
				else if(DELETE != null)
				{
					%>
					<form action="ExamType_controller2" method="get">
						<input type="text" name="Delete">
						<input type="submit" value="Delete" >
					</form>
					<%
					
				}
			}
		%>
 
    </body>
</html>
