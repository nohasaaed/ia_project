/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * @author Noha
 */
@WebServlet(urlPatterns = {"/Search_DB"})
public class Search_DB extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
			String Name=request.getParameter("Name");
			String Email=request.getParameter("Email");
			String ExamType=request.getParameter("ExamType");
			String ExamDate=request.getParameter("ExamDate");
			ArrayList<String> list = new ArrayList();
			
			
			Connection conn = null;
				Statement stat = null;
				conn = DBconnection.openConnection();

				stat = conn.createStatement();

				String q = "";

				ResultSet rs = null;

				Integer id = 0;
				String Id = "";
				try {

					list = Search.search(Name, Email, ExamType, ExamDate);

					for (int i = 0; i < list.size(); i = i + 4) {
						//out.println("User ID = " + list.get(i)); 
						id = Integer.parseInt(list.get(i));
						Id = list.get(i);
						out.println("User Name = " + list.get(i + 1));
						out.println("<br>Email = " + list.get(i + 2));
						out.println("<br>Phone number = " + list.get(i + 3));
						out.println("<br><br>");
						q = " SELECT * FROM choosen_answer where user_id ='" + id + "'; ";
						rs = stat.executeQuery(q);

						if (rs.next()) {
							HttpSession session = request.getSession();

							session.setAttribute("id", id);
							out.print(" <form action=\"ShowUsers\" method=\"POST\">\n"
									+ "			<br>\n"
									+ "			<br>\n"
									+ "			\n"
									+ "			<input type=\"submit\" value=\"Show Detailed Report\"> \n"
									+ "		</form>"); 

							 out.print(" <form action=\"ShowReport\" method=\"POST\">\n"
									+ "			<br>\n"
									+ "			<br>\n"
									+ "			\n"
									+ "			<input type=\"submit\" value=\"Show Summarized Report\"> \n"
									+ "		</form>"); 





						}

					}

				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
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
			Logger.getLogger(Search_DB.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(Search_DB.class.getName()).log(Level.SEVERE, null, ex);
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
