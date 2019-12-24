<%-- 
    Document   : index
    Created on : Dec 19, 2019, 11:03:44 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                String name=session.getAttribute("name").toString();
//           out.print("hello"+name);
%>
<div class="topright"> hello <%=name%></div>
        
        <h3><%=request.getAttribute("Message")%></h3>
    </body>
</html>
