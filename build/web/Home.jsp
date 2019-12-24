<%-- 
    Document   : Home
    Created on : Dec 23, 2019, 12:46:28 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript">
            function openPage(pageURL)
            {
                window.location.href = pageURL;
            }
        </script>
    </head>
    <body>
        <input type="button" value="register" name="register" onclick="openPage('input.jsp')" />
        <input type="button" value="HR" name="HR" onclick="openPage('homeHR.jsp')" />
    </body>
</html>
