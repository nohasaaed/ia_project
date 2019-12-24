package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class getdisapprove_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write(" \n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>display data from the table using jsp</title>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("            function openPage(pageURL)\n");
      out.write("            {\n");
      out.write("                window.location.href = pageURL;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");

try {

String connectionURL = "jdbc:mysql://localhost:3306/iaproject2";
Connection connection = null;
Statement statement = null;
ResultSet rs = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "root");
statement = connection.createStatement();
String QueryString = "SELECT * from user where flag=1";
rs = statement.executeQuery(QueryString);


      out.write("\n");
      out.write("<form>\n");
      out.write("\n");
      out.write("<TABLE cellpadding=\"15\" border=\"1\">\n");

while (rs.next()) {

      out.write("\n");
      out.write("<TR>\n");
      out.write("    <TD>");
      out.print(rs.getInt("id"));
      out.write("</TD>\n");
      out.write("<TD>");
      out.print(rs.getString("name"));
      out.write("</TD>\n");
 String email=rs.getString("email"); 
 session.setAttribute("mail", email);
session.setAttribute("id",rs.getInt("id"));
      out.write("\n");
      out.write("    <TD>   <input type=\"button\" value=\"approve\" name=\"approve\" onclick=\"openPage('HRapprove')\" /></TD>\n");
      out.write("    <TD>  <input type=\"button\" value=\"disapprove\" name=\"disapprove\" onclick=\"openPage('HRdisapprove')\" /></TD>\n");
      out.write("\n");
      out.write("</TR>\n");
      out.write("<!--  <form  action=\"mailto:esraasalah050@gmail.com?subject= job Alert &message=You Are Approved\" method=\"post\">\n");
      out.write("                      \n");
      out.write("                  <input type=\"submit\" value=\" approve\"><br>-->\n");
      out.write("                  \n");
      out.write(" \n");
 } 
      out.write('\n');

// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {

      out.write("\n");
      out.write("<font size=\"+3\" color=\"red\">\n");

out.println("Unable to connect to database.");
}

      out.write("\n");
      out.write("</font>\n");
      out.write("\n");
      out.write("</TABLE>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<!--<TABLE>-->\n");
      out.write("<TR>\n");
      out.write("<TD><FORM ACTION=\"homeHR.jsp\" method=\"get\" >\n");
      out.write("<button type=\"submit\"><-- back</button>\n");
      out.write("<!--</TR>-->\n");
      out.write("<!--</TABLE>-->\n");
      out.write("</Form>\n");
      out.write("</body>\n");
      out.write("</html>");
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
