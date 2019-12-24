<%-- 
    Document   : SearchForCandidate
    Created on : Dec 20, 2019, 6:03:52 PM
    Author     : Noha
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Search For Candidates</title>
    </head>
    <body>
		<%
			String searchType=request.getParameter("searchType");
			%>
		<form action="Search_DB" method="get">
			<%
			if (searchType.contains("name"))
			{
			%>
				By Name:
				<input type="text" name="Name">
			<%
			}
			else if (searchType.contains("email"))
			{
			%>
				By E-Mail:
				<input type="text" name="Email">
			<%
			}
			else if (searchType.contains("examtype"))
			{
			%>
				By Exam Type:
				<select name="ExamType">
					<option value="java" >JAVA</option>
					<option value="python">Python</option>
					<option value="database">DataBase</option>
					<option value="iq">IQ</option>
					<option value="english">English</option>
				</select> 		
			<%
			}
			else if (searchType.contains("examdate"))
			{
			%>
				By Exam Date:
				<input type="text" name="ExamDate">
			<%
			}
			%>
			<input type="submit" value="Next">
		</form>
    </body>
</html>
