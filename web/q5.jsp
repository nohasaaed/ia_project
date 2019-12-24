<%-- 
    Document   : Q1
    Created on : Dec 22, 2019, 4:29:45 PM
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
<h1>Question 5</h1>
        <%
            String name = request.getSession().getAttribute("session_Name").toString();
            String password = session.getAttribute("session_pass").toString();
            
            String val = request.getParameter("exam_type");

            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();

            Random r = new Random();
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/iaproject2";
            String user = "root";
            String pass = "root";
            Connection Con = null;
            Statement Stmt = null;

            String Qid = null;
            String x = null;
            String Aid = null;
            String Qtext = null;

            int cid=0;
            Con = DriverManager.getConnection(url, user, pass);
            Stmt = Con.createStatement();

            
            String query1 = "SELECT * FROM user WHERE name='" + name + "' ";
            ResultSet RSS = Stmt.executeQuery(query1);
            while (RSS.next()) {
                cid = Integer.parseInt(RSS.getString("id"));
            }
                
                
                
                String query = "SELECT * FROM question WHERE exam_type='" + val + "' ORDER BY RAND() LIMIT 1";
                ResultSet RS = Stmt.executeQuery(query);
                while (RS.next()) {
                    Qid = RS.getString("qid");
                    Qtext = RS.getString("qtext");
                }

                out.println(Qtext);

                String queryy = "SELECT * FROM answer WHERE correct=0 and qid='" + Qid + "' ORDER BY RAND() LIMIT 3";
                ResultSet RST = Stmt.executeQuery(queryy);
                while (RST.next()) {
                    list.add(RST.getString("atext"));
                    list2.add(RST.getString("aid"));
                }

                String quer = "SELECT * FROM answer WHERE correct=1 and qid='" + Qid + "' ORDER BY RAND() LIMIT 1";
                ResultSet R = Stmt.executeQuery(quer);
                while (R.next()) {
                    list.add(R.getString("atext"));
                    list2.add(R.getString("aid"));

                }

                //out.println(list);
        %>
        
        <form method="get" action="q5">
        <%for (int i = 0; i < list.size(); i++) {%>
        <input type="radio" name="<%=Qid%>" value="<%=list2.get(i)%>"><%=list.get(i)%><br>
        <%if(i==list.size()-1)%>
        <input type="hidden" value="<%=val%>" name="exam_type" />
        <br>
        
        <%}session.setAttribute("qid",Qid);
        %>

        <input type="submit">
        </form>

    </body>
</html>
