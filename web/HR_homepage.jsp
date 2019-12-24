<%-- 
    Document   : HR_homepage
    Created on : Dec 20, 2019, 5:59:41 PM
    Author     : Noha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HR Home page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
		<form action="SearchForCandidates" method="get">
			<br>
			<br>
			
			Search For Candidates by-
			<select name="searchType">
				<option value="name" >User Name</option>
				<option value="email">E-mail</option>
				<option value="examtype">Exam type</option>
				<option value="examdate">Exam date</option>
			</select> 	
			
			<input type="submit" value="Next"> 
		</form>
		
		<form action="ExamType_controller" method="get">
			<br>
			<br>
			
			<input type="submit" value="Exam Type"> 
		</form>
		
		<form action="QuestionAndAnswers" method="get">
			<br>
			<br>
			
			<input type="submit" value="Questions-Answers"> 
		</form>
    </body>
</html>
