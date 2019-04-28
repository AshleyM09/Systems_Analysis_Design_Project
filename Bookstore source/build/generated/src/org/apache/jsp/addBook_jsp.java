package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Books</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Book Information</h1>\n");
      out.write("        <p>Please enter required information:</p>\n");
      out.write("        <form action=\"AddBookServlet\" method=\"POST\">\n");
      out.write("            <p>Book Name: <input type=\"text\" name=\"bookName\" value=\"\" size=\"50\" /><br />\n");
      out.write("                <br>\n");
      out.write("                ISBN: <input type=\"text\" name=\"isbn\" value=\"\" size=\"13\" /><br />\n");
      out.write("                <br>\n");
      out.write("                Author: <input type=\"text\" name=\"author\" value=\"\" size=\"20\" /><br />\n");
      out.write("                <br>\n");
      out.write("                Condition: <input type=\"text\" name=\"bookCondition\" value=\"\" size=\"4\" /><br />\n");
      out.write("                <br>\n");
      out.write("                Description: <input type=\"text\" name=\"description\" value=\"\" size=\"4\" /><br />\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                Price: <input type=\"text\" name=\"price\" value=\"\" size=\"5\" /><br />\n");
      out.write("                <br>\n");
      out.write("                Quantity: <input type=\"text\" name=\"quantity\" value=\"\" size=\"2\" /><br />\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" value=\"Add Book\" name=\"submit\" />\n");
      out.write("           \n");
      out.write("            </p>\n");
      out.write("        </form>\n");
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
