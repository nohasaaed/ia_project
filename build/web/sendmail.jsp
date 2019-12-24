<%-- 
    Document   : sendmail
    Created on : Dec 23, 2019, 2:36:34 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
            <% String email= session.getAttribute("mail").toString();%>

    <body>
        
        <form class="form" action="mailto:nadasamir169@gmail.com?subject= job Alert &message=You Are Approved" method="post">
                       <input  type="radio" name="choose" value="approve">approve<br>
                        
<!--        <input type="radio" name="choose" value="disapprove">disapprove<br>-->
                
                  <input type="submit" value=" send"><br>
              
      
                  
  </form>
    </body>
</html>
