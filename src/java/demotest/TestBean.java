package demotest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
 
public class TestBean implements Serializable{
    
    String email,password,uname,tele="";
	
      public String getusername() {
		return uname;
	}
	public void setusername(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
        public String gettele() {
		return tele;
	}
	public void settele(String tele) {
		this.tele = tele;
	}

 
 
    
      public void RegisterUser() 
    {
        try
        { 
            
            
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/iaproject2";
                String user = "root";
                String pass = "root";
                Connection Con = null;
                Statement Stmt = null;
                Con = DriverManager.getConnection(url, user, pass);
                Stmt = Con.createStatement();
            
                String query="INSERT INTO user (email,password,name,phone,flag) VALUES "
                + "('"+email+"','"+password+"','"+uname+"','"+tele+"','"+0+"')";
                int Rows = Stmt.executeUpdate(query);
            
//            if(RS.next()){
//                    out.print("exist");
//                }
//                else{
//                out.print("doesn't exist");
//                }
//              int Rows = Stmt.executeUpdate(query);
            
                Stmt.close();
                Con.close();
            
        }catch (Exception ex) {
                ex.printStackTrace();
            }}
    
     
    
    
    
    
    
        
        
        
        
 
}