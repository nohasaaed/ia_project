<%-- 
    Document   : exams
    Created on : Dec 21, 2019, 7:14:32 PM
    Author     : note book
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  
            String name = request.getSession().getAttribute("session_Name").toString();
            String password = session.getAttribute("session_pass").toString();
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/iaproject2";
            String user = "root";
            String pass = "root";
            Connection Con = null;
            Statement Stmt = null;
            Con = DriverManager.getConnection(url, user, pass);
            Stmt = Con.createStatement();

            ArrayList list = new ArrayList<>();

            int cid=0;

            String query1 = "SELECT * FROM user WHERE name='" + name + "' ";
            ResultSet RSS = Stmt.executeQuery(query1);
            while (RSS.next()) {
                cid = Integer.parseInt(RSS.getString("id"));
            }
            
            String query = "SELECT * FROM user_exam WHERE user_id='" + cid + "' ";
            ResultSet RS = Stmt.executeQuery(query);
            while (RS.next()) {
                list.add(RS.getString("exam_type"));
            }
        %>
        <h1>List of Exams</h1>
        <%for(int i=0;i<list.size();i++){%>
        <h3><%=list.get(i)%><a href="q1.jsp?exam_type=<%=list.get(i)%>"><button>Start</button></a></h3> 
        <%}%>
    </body>
</html>
