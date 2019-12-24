<%-- 
    Document   : mvc_success
    Created on : Dec 15, 2019, 8:00:44 PM
    Author     : nada
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@page import="demotest.TestBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            .topright {
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 18px;
}

        </style>
    </head>
    <body>
     

<%
    try{
        ResultSet resultset =null;
        Class.forName("com.mysql.jdbc.Driver");
Connection connection = null;
String databaseURL = "jdbc:mysql://localhost:3306/iaproject2";
    String user = "root";
    String password = "root";
    connection = DriverManager.getConnection(databaseURL, user, password);
       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from position") ;

%>
<center>
        <h1>File Upload and choose position</h1>
        <form method="post" action="controllerfile" enctype="multipart/form-data">
                    
                    <input type="file" name="photo" size="50"/>
                    <select name="item">
        <%  while(resultset.next()){ %>
        <option value="<%=resultset.getInt("id")%>"><%= resultset.getString("name")%></option>
        <%        
} %>
        </select>
                        <input type="submit" value="Save"> 
        </form>
    </center>
<%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>


    </body>
</html>
