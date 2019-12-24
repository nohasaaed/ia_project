<%-- 
    Document   : QuestionAndAnswers
    Created on : Dec 22, 2019, 11:34:46 PM
    Author     : Noha
--%>

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
//		String edit=request.getParameter("edit");
		String edit="";
		if (edit != null)
		{
			//out.println(edit +" "+questionID);
			%>
			<form action="QuestionAndAnswers.jsp" method="get">
				<input type="submit" value="Add" name="add">
				<input type="submit" value="Update Question" name="updateQ" >
				<input type="submit" value="Update Answer" name="updateA">
				<input type="submit" value="Delete Question" name="deleteQ" >
				<input type="submit" value="Delete Answer" name="deleteA" >
			</form>
			
			<%
		}
		
		String ADD=request.getParameter("add");
		String UPDATE_Q=request.getParameter("updateQ");
		String UPDATE_A=request.getParameter("updateA");
		String DELETE_Q=request.getParameter("deleteQ");
		String DELETE_A=request.getParameter("deleteA");
		
			if ((ADD != null) || (UPDATE_Q != null) ||(UPDATE_A != null) || (DELETE_Q != null) || (DELETE_A != null) ) 
			{
				if(ADD != null)
				{
					%>
					<form action="QuestionAndAnswers2" method="get">
						Add question :<br>
						<input type="text" name="newQ"><br><br>
						exam type = 
						<input type="text" name="newExamType"><br>
						
						
						Add answers :<br>
						<input type="text" name="newA1"> State <input type="text" name="sA1"><br>
						<input type="text" name="newA2">State <input type="text" name="sA1"><br>
						<input type="text" name="newA3">State <input type="text" name="sA1"><br>
						<input type="text" name="newA4">State <input type="text" name="sA1"><br><br>
						
						<input type="submit" value="Add" name="Add" ><br><br>
					</form>
					<%
					
				}
				else if (UPDATE_Q != null)
				{
					%>
					<form action="QuestionAndAnswers2" method="get">
						Enter question number you want to update<br>
						<input type="text" name="question_no"><br><br>

						Enter new question<br>
						<input type="text" name="updateQ"><br><br>
						
						
						<input type="submit" value="Update" ><br><br>
					</form>
					<%
				}
				else if (UPDATE_A != null)
				{
					%>
					<form action="QuestionAndAnswers2" method="get">
						Enter answer number you want to update<br>
						<input type="text" name="answer_no"><br><br>

						Enter new answer<br>
						<input type="text" name="updateA"><br><br>
						
						<input type="submit" value="Update" ><br><br>
					</form>
					<%
				}
				else if(DELETE_Q != null)
				{
					//QustionAndAnswers_DB.DELETE_Q(Integer.parseInt(questionID));
					%>
					<form action="QuestionAndAnswers2" method="get">
						reEnter question number<br>
						<input type="text" name="question_no"><br><br>

						<input type="submit" value="delete" name="deleteQ"><br><br>
					</form>
					<%
				}
				else if(DELETE_A != null)
				{
					%>
					<form action="QuestionAndAnswers2" method="get">
						Enter answer number you want to delete<br>
						<input type="text" name="answer_no"><br><br>

						
					
					
					<input type="submit" value="Delete" >
					</form>
					<%
					
				}
			}
		%>
		
		

    </body>
</html>
