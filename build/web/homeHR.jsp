<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<html> 
<head> 
<title>display data from the table using jsp</title>
</head> 
<body>
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
	
	
<TABLE>
<TR>
<TD align="center"><h2>To display all the data from the 
table click here</h2></TD>
</TR>
<TR>
<TD align="center"><A HREF="getdisapprove.jsp">
<font size="4" color="blue">show data from table</font>
</A></TD>
</TR>
</TABLE>
</body> 
</html>