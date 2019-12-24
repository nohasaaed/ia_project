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
@WebServlet(urlPatterns = {"/SearchForCandidates"})
public class SearchForCandidates extends HttpServlet {

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
			
			String searchType=request.getParameter("searchType");
			out.print("<form action=\"Search_DB\" method=\"get\">");
			if (searchType.contains("name"))
			{
				out.print("By Name:\n" +
"				<input type=\"text\" name=\"Name\">");
				
			}
			else if (searchType.contains("email"))
			{
				out.print("By E-Mail:\n" +
"				<input type=\"text\" name=\"Email\">");
			}
			else if (searchType.contains("examtype"))
			{
				ArrayList<String> list = ExamType.GET();
				out.print("By Exam Type:\n" 
						+"<select name=\"ExamType\">");
				for (int i=0 ; i<list.size() ; i++)
				{
					out.print( "	<option value=\'"+list.get(i)+"\' >\'"+list.get(i)+"\'</option>");
				}
				out.print( "</select> 	");
				
			}
			else if (searchType.contains("examdate"))
			{
				out.print("By Exam Date:\n" +
"				<input type=\"text\" name=\"ExamDate\">");
			}	
			out.print("<input type=\"submit\" value=\"Next\">\n" +
"		</form>");
			out.print("");
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
