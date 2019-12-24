package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QuestionAndAnswers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t");

		String edit=request.getParameter("edit");

		if (edit != null)
		{
			//out.println(edit +" "+questionID);
			
      out.write("\n");
      out.write("\t\t\t<form action=\"QuestionAndAnswers.jsp\" method=\"get\">\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Add\" name=\"add\">\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Update Question\" name=\"updateQ\" >\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Update Answer\" name=\"updateA\">\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Delete Question\" name=\"deleteQ\" >\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Delete Answer\" name=\"deleteA\" >\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t");

		}
		
		
		String ADD=request.getParameter("add");
		String UPDATE_Q=request.getParameter("updateQ");
		String UPDATE_A=request.getParameter("updateA");
		String DELETE_Q=request.getParameter("deleteQ");
		String DELETE_A=request.getParameter("deleteA");
		
			if ((ADD != null) || (UPDATE_Q != null) ||(UPDATE_A != null) || (DELETE_Q != null) || (DELETE_A != null) ) 
			{
				if(ADD != null)
				{
					
      out.write("\n");
      out.write("\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\tAdd question :<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newQ\"><br><br>\n");
      out.write("\t\t\t\t\t\texam type = \n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newExamType\"><br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\tAdd answers :<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newA1\"> State <input type=\"text\" name=\"sA1\"><br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newA2\">State <input type=\"text\" name=\"sA1\"><br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newA3\">State <input type=\"text\" name=\"sA1\"><br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"newA4\">State <input type=\"text\" name=\"sA1\"><br><br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Add\" name=\"Add\" ><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

					
				}
				else if (UPDATE_Q != null)
				{
					
      out.write("\n");
      out.write("\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\tEnter question number you want to update<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"question_no\"><br><br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"ok\" name=\"ok\" ><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

					if(request.getParameter("question_no")!=null &&request.getParameter("ok")!=null )
					{
						
      out.write("\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\tEnter new question<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"updateQ\"><br><br>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Update\" ><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

				}
				else if (UPDATE_A != null)
				{
					
      out.write("\n");
      out.write("\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\tEnter answer number you want to update<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"answer_no\"><br><br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"ok\" name=\"ok\" ><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

					if(request.getParameter("answer_no")!=null &&request.getParameter("ok")!=null )
					{
						
      out.write("\n");
      out.write("\t\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\tEnter new answer<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"updateA\"><br><br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Update\" ><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t");

					}
				}
				else if(DELETE_Q != null)
				{
					//QustionAndAnswers_DB.DELETE_Q(Integer.parseInt(questionID));
					
      out.write("\n");
      out.write("\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\treEnter question number<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"question_no\"><br><br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"delete\" name=\"deleteQ\"><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

				}
				else if(DELETE_A != null)
				{
					
      out.write("\n");
      out.write("\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\tEnter answer number you want to delete<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"answer_no\"><br><br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"delete\" name=\"ok\"><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

					if(request.getParameter("answer_no")!=null &&request.getParameter("ok")!=null )
					{
//						QustionAndAnswers_DB.DELETE_A(Integer.parseInt(request.getParameter("answer_no")));
						
      out.write("\n");
      out.write("\t\t\t\t\t\t<form action=\"QuestionAndAnswers2\" method=\"get\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"delete\" name=\"deleteA\"><br><br>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t");

					}
					
      out.write("\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Delete\" >\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t");

					
				}
			}
		
      out.write("\n");
      out.write(" \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
