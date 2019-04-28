package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add New Customer</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Add a New Customer</h1>\n");
      out.write("        <p>Enter the fields below to add a new apartment listing.</p>\n");
      out.write("        <form action=\"AddCustomerServlet\" method=\"POST\">\n");
      out.write("            <p>Create Username: <input type=\"text\" name=\"username\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Create Password: <input type=\"text\" name=\"password\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Enter Last Name: <input type=\"text\" name=\"last\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Enter First Name: <input type=\"text\" name=\"first\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Address: <input type=\"text\" name=\"address\" value=\"\" size=\"20\" /><br />\n");
      out.write("               City: <input type=\"text\" name=\"city\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Zip Code: <input type=\"text\" name=\"zipcode\" value=\"\" size=\"5\" /><br />\n");
      out.write("               State: <input type=\"text\" name=\"state\" value=\"\" size=\"20\" /><br />\n");
      out.write("               Phone Number: <input type=\"text\" name=\"phonenumber\" value=\"\" size=\"10\" /><br />\n");
      out.write("               Email: <input type=\"text\" name=\"email\" value=\"\" size=\"20\" /><br />\n");
      out.write("                <input type=\"submit\" value=\"Add Customer\" name=\"submit\" />\n");
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
