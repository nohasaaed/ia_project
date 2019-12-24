/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.oracle.jrockit.jfr.DataType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hager
 */
@WebServlet(urlPatterns = {"/ShowUsers"})
public class ShowUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Integer id = (Integer) session.getAttribute("id");
        //    out.println(id);
            Connection conn = null;
            Statement stmt = null;
            Statement stmt1 = null;
            Statement stmt2 = null;

            //display connection
            conn = DBconnection.openConnection();
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();
            stmt2 = conn.createStatement();

            String Q = "";
            String Q1 = "";
            String Q2 = "";

            ResultSet RS = null;
            ResultSet RS1 = null;
            ResultSet RS2 = null;

            Q = "   select * from choosen_answer \n"
                    + "where user_id = '" + id + "'  \n"
                    + "group by exam_type having count(*) >=1 ; ";
            RS = stmt.executeQuery(Q);
            while (RS.next()) {
                String exam_type = RS.getString("exam_type");
                out.println("<br>Exam type is : " + exam_type);
                out.println("<br>");
                out.println("<br>Questions and Answers: " );  
                out.println("<br>");
                
//                Q1 = "  SELECT qtext FROM question\n" +
//"WHERE qid IN (select qid from choosen_answer where user_id = '" + id + "' and exam_type='"+exam_type+"' ) ;  " ;   
                 Q1 = "SELECT qtext FROM question\n" +
"WHERE qid IN (select qid from choosen_answer where user_id = '" + id + "' and exam_type='"+exam_type+"' ) union  \n" +
"SELECT atext FROM answer\n" +
"WHERE aid IN (select aid from choosen_answer where user_id = '" + id + "' and exam_type='"+exam_type+"' ) ; " ; 
                 RS1 = stmt1.executeQuery(Q1); 
                  while (RS1.next()) // for loop 5 times LATEEEER
                  { 
                     out.println(RS1.getString("qtext"));   
                     //out.println(RS1.getString("atext"));  

                     out.println("<br>");
                  }

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShowUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShowUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
