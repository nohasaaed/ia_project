package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class input_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            function validateForm() {\n");
      out.write("                var x = document.forms[\"myForm\"][\"email\"].value;\n");
      out.write("                var y = document.forms[\"myForm\"][\"pass\"].value;\n");
      out.write("                var z = document.forms[\"myForm\"][\"uname\"].value;\n");
      out.write("               \n");
      out.write("                var atposition = x.indexOf(\"@\");\n");
      out.write("                var dotposition = x.lastIndexOf(\".\");\n");
      out.write("                if (x === \"\"||z===\"\") {\n");
      out.write("                  window.alert(\"Name must be filled out\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                \n");
      out.write("\n");
      out.write("                if (y.length < 6 || y === \"\") {\n");
      out.write("                    alert(\"Password must be at least 6 characters long.\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= x.length) {\n");
      out.write("                    alert(\"Please enter a valid e-mail address \\n \");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("                function checkExist(){\n");
      out.write("                var xmlhttp = new XMLHttpRequest();\n");
      out.write("                var username = document.forms[\"myForm\"][\"uname\"].value;\n");
      out.write("                var url = \"checkusername.jsp?uname=\" + username;\n");
      out.write("                xmlhttp.open(\"GET\",url,true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("                xmlhttp.onreadystatechange = function(){\n");
      out.write("                    if(xmlhttp.readyState === 4 && xmlhttp.status === 200){\n");
      out.write("                        if(xmlhttp.responseText ===\"User name is already exist\"){\n");
      out.write("                        document.getElementById(\"isE\").style.color = \"red\";\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                  \n");
      out.write("                   \n");
      out.write("               else\n");
      out.write("               { document.getElementById(\"isE\").style.color = \"green\";\n");
      out.write("                       }\n");
      out.write("                  \n");
      out.write("                     \n");
      out.write("                        document.getElementById(\"isE\").innerHTML = xmlhttp.responseText;\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("<form  name=\"myForm\" action=\"controller\"  onsubmit=\"return validateForm()\" method=\"Post\">\n");
      out.write("Username:<input type=\"text\" name=\"uname\" onblur=\"checkExist()\" /><span id=\"isE\"></span><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br> \n");
      out.write("<br>\n");
      out.write("Email: <input type=\"text\" name=\"email\">\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("Password: <input type=\"password\" name=\"pass\" />\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("telephone: <input type=\"text\" name=\"tele\" />\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<input id=\"Button\" type=\"submit\" value=\"Register\">\n");
      out.write("</form>\n");
      out.write("        <span id=\"amit\"> </span>\n");
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
