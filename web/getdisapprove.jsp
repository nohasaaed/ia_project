<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<title>display data from the table using jsp</title>
<script type="text/javascript">
            function openPage(pageURL)
            {
                window.location.href = pageURL;
            }
        </script>
</head>
<body>
<%
try {

String connectionURL = "jdbc:mysql://localhost:3306/iaproject2";
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "root");
statement = connection.createStatement();
String QueryString = "SELECT * from user where flag=1";
rs = statement.executeQuery(QueryString);

%>
<form>

<TABLE cellpadding="15" border="1">
<%
while (rs.next()) {
%>
<TR>
    <TD><%=rs.getInt("id")%></TD>
<TD><%=rs.getString("name")%></TD>
<% String email=rs.getString("email"); 
 session.setAttribute("mail", email);
session.setAttribute("id",rs.getInt("id"));%>
    <TD>   <input type="button" value="approve" name="approve" onclick="openPage('HRapprove')" /></TD>
    <TD>  <input type="button" value="disapprove" name="disapprove" onclick="openPage('HRdisapprove')" /></TD>

</TR>
<!--  <form  action="mailto:esraasalah050@gmail.com?subject= job Alert &message=You Are Approved" method="post">
                      
                  <input type="submit" value=" approve"><br>-->
                  
 
<% } %>
<%
// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>
<font size="+3" color="red">
<%
out.println("Unable to connect to database.");
}
%>
</font>

</TABLE>
</form>

<!--<TABLE>-->
<TR>
<TD><FORM ACTION="homeHR.jsp" method="get" >
<button type="submit"><-- back</button>
<!--</TR>-->
<!--</TABLE>-->
</Form>
</body>
</html>