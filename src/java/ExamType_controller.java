/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/ExamType_controller"})
public class ExamType_controller extends HttpServlet {

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
			ArrayList<String> list = new ArrayList();
			list = ExamType.GET() ;
			
			out.println("<br>Exam Types : ");
			for (int i=0 ; i<list.size() ; i++)
			{
				out.println("<br>");
				out.println(list.get(i));
					
			}
		}catch(Exception e){
			System.err.println();
		}
		out.println("<form action=\"ExamType_controller.jsp\" method=\"get\">\n" +
"			<br>\n" +
"			<br>\n" +
"			\n" +
"			<input type=\"submit\" value=\"ADD\" name=\"add\"> \n" +
"			<br>\n" +
"			<br>\n" +
"			\n" +
"			<input type=\"submit\" value=\"UPDATE\" name=\"update\"> \n" +
"			<br>\n" +
"			<br>\n" +				
"			\n" +
"			<input type=\"submit\" value=\"DELETE\" name=\"delete\"> \n" +
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
