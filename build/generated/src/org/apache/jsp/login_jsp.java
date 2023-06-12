package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String customerID = (String) request.getAttribute("customerID");
            String registrationStatus = (String) request.getAttribute("registrationStatus");
            String loginStatus = (String) request.getAttribute("loginStatus");
            if (customerID != null && registrationStatus != null && registrationStatus.equals("success")) { 
      out.write("\n");
      out.write("                <p>Registration successful. Your Customer ID is: ");
      out.print( customerID );
      out.write("</p>\n");
      out.write("        ");
  }
            if (loginStatus != null && loginStatus.equals("failed")) {
                out.println("Login failed...! Please check your credentials.");
            }
        
      out.write("\n");
      out.write("        <div class=\"Navbar-layout\">\n");
      out.write("            <div class=\"Navbar\">\n");
      out.write("                <div class=\"Nav-left\">\n");
      out.write("                    <div class=\"logo\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"Nav-mid\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"Nav-right\">\n");
      out.write("                    <div class=\"nav-menu\">\n");
      out.write("                        <ul class=\"nav-name\">\n");
      out.write("                            <li><a class=\"main-link\" href=\"#home\">Home</a></li>\n");
      out.write("                            <li><a class=\"other-link\" href=\"login.jsp\">Login</a></li>\n");
      out.write("                            <li><a class=\"other-link\" href=\"register.jsp\">Register</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"Background\">\n");
      out.write("            <div class=\"background-left\">\n");
      out.write("                <div>\n");
      out.write("                    <form action=\"LoginChecker\" method=\"post\"> <!--Whenever a form is submit a data it send it to a servlet.-->\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Customer ID:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"customerID\" placeholder=\"Enter Customer ID\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password:</td>\n");
      out.write("                    <td><input type=\"text\" name=\"password\" placeholder=\"Enter password\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Login\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"register.jsp\">register</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"background-right\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
