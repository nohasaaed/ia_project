<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
       // out.println("-----------------------");
        String uname = request.getParameter("uname");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/iaproject2", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM user WHERE " +
                    "name = '"+uname+"'");
            //ps.setString(1,request.getParameter("username"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("User name is already exist");
                
                
            }else{
                out.print(uname+"User name is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>