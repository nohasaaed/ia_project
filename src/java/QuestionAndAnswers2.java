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
@WebServlet(urlPatterns = {"/QuestionAndAnswers2"})
public class QuestionAndAnswers2 extends HttpServlet {

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
			
			String newQ=request.getParameter("newQ");
			String newExamType=request.getParameter("newExamType");
			
			String answer_no=request.getParameter("answer_no");
			String question_no=request.getParameter("question_no");
			
			ArrayList<String> AddAnswer = new ArrayList();
			AddAnswer.add(request.getParameter("newA1"));
			AddAnswer.add(request.getParameter("newA2"));
			AddAnswer.add(request.getParameter("newA3"));
			AddAnswer.add(request.getParameter("newA4"));
			
			ArrayList<String> Addstate = new ArrayList();
			Addstate.add(request.getParameter("sA1"));
			Addstate.add(request.getParameter("sA2"));
			Addstate.add(request.getParameter("sA3"));
			Addstate.add(request.getParameter("sA4"));
			
			String UPDATE_Q=request.getParameter("updateQ");
			String UPDATE_A=request.getParameter("updateA");
			
			String DELETE_Q=request.getParameter("deleteQ");
			String DELETE_A=request.getParameter("deleteA");
			
			if ((newExamType != null) ||(newQ != null) || (UPDATE_Q != null) ||(UPDATE_A != null) || (DELETE_Q != null) || (DELETE_A != null) ) 
			{
				if((newExamType != null) &&(newQ != null))
				{
					QustionAndAnswers_DB.SAVE_Q(newQ ,  newExamType);
					for (int i =0 ; i < AddAnswer.size() ; i ++)
					{
						String atext =  AddAnswer.get(i);
						String correct = Addstate.get(i);
						QustionAndAnswers_DB.SAVE_A(atext , correct);
					}
				}
				else if (UPDATE_Q != null)
				{
					QustionAndAnswers_DB.UPDATE(Integer.parseInt(question_no) , UPDATE_Q);
				}
				else if (UPDATE_A != null)
				{
					QustionAndAnswers_DB.UPDATE_A(Integer.parseInt(answer_no ),UPDATE_A);
				}
				else if  (DELETE_Q != null) 
				{
					QustionAndAnswers_DB.DELETE_Q(Integer.parseInt(question_no));
				}
				else if (DELETE_A != null)
				{
					QustionAndAnswers_DB.DELETE_A(Integer.parseInt(answer_no));
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
