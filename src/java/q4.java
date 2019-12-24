package demotest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/q4"})
public class q4 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/iaproject2";
            String user = "root";
            String pass = "root";
            Connection Con = null;
            Statement Stmt = null;
            Con = (Connection) DriverManager.getConnection(url, user, pass);
            Stmt = Con.createStatement();

            String val = request.getParameter("exam_type");

            String name = request.getSession().getAttribute("session_Name").toString();
            String password = request.getSession().getAttribute("session_pass").toString();
            // String exam = request.getSession().getAttribute("exam_type").toString();

            ArrayList<String> list = new ArrayList<String>();


            String aid = null;

            int cid = 0;

            String query1 = "SELECT * FROM user WHERE name='" + name + "' ";
            ResultSet RSS = Stmt.executeQuery(query1);
            while (RSS.next()) {
                cid = Integer.parseInt(RSS.getString("id"));
            }

            String qid = request.getSession().getAttribute("qid").toString();

            String value = request.getParameter(qid);

            //out.println(qid);
            //out.println(val);
            //int i = Stmt.executeUpdate("insert into candidate_answers(cid,qid,aid)values('" + cid + "','" + qid + "','" + value + "')");
            String query = "SELECT * FROM answer WHERE correct=1 and qid='" + qid + "'";
            ResultSet RS = Stmt.executeQuery(query);
            while (RS.next()) {
                aid = RS.getString("aid");
                list.add(aid);

            }

            if (list.contains(value)) {
                out.println("Correct");
	String Q = "insert into choosen_answer(user_id,qid,aid,score,exam_date,exam_type)values('" +
						cid + "','" + qid + "','" + value + "','1','2020-12-04','" + val + "' );";
           int i = Stmt.executeUpdate(Q);

            } else {
                out.println("Wrong Answer");
           int i = Stmt.executeUpdate("insert into choosen_answer(user_id,qid,aid,score,exam_date,exam_type)values('" + 
										cid + "','" + qid + "','" + value + "','0','2020-12-04','" + val + "' );");

            }

            // response.sendRedirect("q2.jsp?exam_type='"+val+"'");
            out.print("<form method=\"get\" action=\"q5.jsp\">\n"
                    + "        <input type=\"Submit\" value=\"Next\"><br>\n"
                    + "        <input type=\"hidden\" value=\'" + val + "\' name=\"exam_type\" />\n"
                    + "        <br>\n"
                    + "        \n");

        } catch (Exception ex) {
            ex.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
