package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.UserDbUtil;
import java.util.List;
import domain.Users;
import java.io.PrintWriter;;

public final class AdmPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html;charset=windows-1250");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"utilStyle.css\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1250\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    ");

    try{
   		if(session.getAttribute("PRIVILEGES").equals("Adm")) {
	 
      out.write("\r\n");
      out.write("\t    <div style=\"float: left;\">\r\n");
      out.write("\t    <a href=\"/upDatePrivileges.jsp\">Edit Privileges</a><br/>\r\n");
      out.write("\t    <a href=\"logout.jsp\">Logout</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div id=\"navel\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table border='1'>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Username</td>\r\n");
      out.write("\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t<td>Email</td>\r\n");
      out.write("\t\t\t\t\t<td>Privileges</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					List<Users> db = UserDbUtil.getUsers();
					
					for(Users user:db)
					{
						out.println("<tr>");
						out.println("<td>"+user.getUsername()+"</td>");
						out.println("<td>"+user.getPassword()+"</td>");
						out.println("<td>"+user.getEmail()+"</td>");
						out.println("<td>"+user.getPrivileges()+"</td>");
						out.println("</tr>");
					}	
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table><br />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");

		}
		else if(session.getAttribute("PRIVILEGES").equals("Bsc") || session.getAttribute("PRIVILEGES").equals("Prm")) {
			response.sendRedirect((String) session.getAttribute("REDIRECT"));
		}
	 }
	catch(Exception e) {
		response.sendRedirect("signInForm.jsp");
	}
	
      out.write("\r\n");
      out.write("\t</body>\r\n");
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
