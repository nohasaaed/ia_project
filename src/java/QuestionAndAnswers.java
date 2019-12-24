/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Noha
 */
@WebServlet(urlPatterns = {"/QuestionAndAnswers"})
public class QuestionAndAnswers extends HttpServlet {

	
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			try{
				ArrayList<String> Q = QustionAndAnswers_DB.GET_Q();
				ArrayList<String> ID = QustionAndAnswers_DB.GET_A();
				for (int i=0  ; i< Q.size() ; i=i+3)
				{
					out.print( Q.get(i) +"<br><br>");
//					for (int j=2 ; j< A.size() ; j=j+3)
//					{
						out.print(Q.get(i+1)+"<br>");
						out.print("State = "+Q.get(i+2)+"<br><br>");
//					}
				}
				
			}catch(Exception e) {
				System.err.println(e.getMessage()); 
			}
//			out.println("<form action=\"QuestionAndAnswers\" method=\"get\">\n" +
//"			<br>\n" +
//"			<br>\n" +
//"			\n" +
//"			<input type=\"submit\" value=\"ADD\" name=\"add\"> \n" +
//"			<br>\n" +
//"			<br>\n" +
//"			\n" +
//"			<input type=\"submit\" value=\"UPDATE\" name=\"update\"> \n" +
//"			<br>\n" +
//"			<br>\n" +				
//"			\n" +
//"			<input type=\"submit\" value=\"DELETE\" name=\"delete\"> \n" +
//"		</form>");
			
			out.println("<form action=\"QuestionAndAnswers.jsp\" method=\"get\">\n" +
"			<br>\n" +
"			<br>\n" +
"			\n" +
					
"			<input type=\"submit\" value=\"ADD_UPDATE_DELETE\" name=\"edit\"> \n" +
"		</form>");
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
