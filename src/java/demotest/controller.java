package demotest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author nada
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");

        String pass = request.getParameter("pass");
        String tele = request.getParameter("tele");
        

        TestBean testobj = new TestBean();
        testobj.setusername(uname);
        testobj.setEmail(email);
        testobj.setPassword(pass);
        testobj.settele(tele);
        testobj.RegisterUser();
        
        
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/iaproject2";
                String user = "root";
                String passw = "root";
                Connection Con = null;
                Statement Stmt = null;
                Con = DriverManager.getConnection(url, user, passw);
                String query = "select * from user where email='"+email+"' and password='"+pass+"'";
                Stmt = Con.createStatement();
                HttpSession session=request.getSession(true);
                 ResultSet RS=Stmt.executeQuery(query);
                if(RS.next()){
                    session.setAttribute("ID", RS.getString("id"));
                    session.setAttribute("name", RS.getString("name"));
  
                }
      
      }
      
      catch (Exception ex) {
                ex.printStackTrace();
            }
//       
        request.setAttribute("gurubean", testobj);
     
        RequestDispatcher rd = request.getRequestDispatcher("mvc_success.jsp");
        rd.forward(request, response);
    }

}
