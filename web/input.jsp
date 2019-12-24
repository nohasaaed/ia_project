<%-- 
    Document   : input
    Created on : Dec 15, 2019, 7:53:04 PM
    Author     : nada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">

            function validateForm() {
                var x = document.forms["myForm"]["email"].value;
                var y = document.forms["myForm"]["pass"].value;
                var z = document.forms["myForm"]["uname"].value;
               
                var atposition = x.indexOf("@");
                var dotposition = x.lastIndexOf(".");
                if (x === ""||z==="") {
                  window.alert("Name must be filled out");
                    return false;
                }
                
                

                if (y.length < 6 || y === "") {
                    alert("Password must be at least 6 characters long.");
                    return false;
                }



                if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= x.length) {
                    alert("Please enter a valid e-mail address \n ");
                }
            }
            
                function checkExist(){
                var xmlhttp = new XMLHttpRequest();
                var username = document.forms["myForm"]["uname"].value;
                var url = "checkusername.jsp?uname=" + username;
                xmlhttp.open("GET",url,true);
                xmlhttp.send();
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
                        if(xmlhttp.responseText ==="User name is already exist"){
                        document.getElementById("isE").style.color = "red";
                    }
                    
                    
                  
                   
               else
               { document.getElementById("isE").style.color = "green";
                       }
                  
                     
                        document.getElementById("isE").innerHTML = xmlhttp.responseText;
                        
                    }
                    
                }
            }
            
            
            
            
            
            
            
            </script>
    </head>
    <body>
<form  name="myForm" action="controller"  onsubmit="return validateForm()" method="Post">
Username:<input type="text" name="uname" onblur="checkExist()" /><span id="isE"></span><br><br>


<br> 
<br>
Email: <input type="text" name="email">
<br>
<br>
Password: <input type="password" name="pass" />
<br>
<br>
telephone: <input type="text" name="tele" />
<br>
<br>
<input id="Button" type="submit" value="Register">
</form>
        <span id="amit"> </span>
    </body>
</html>
