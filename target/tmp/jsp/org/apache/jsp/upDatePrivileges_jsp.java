package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.UserDbUtil;
import java.util.List;
import domain.Users;
import java.io.PrintWriter;;

public final class upDatePrivileges_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write(" \t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"utilStyle.css\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1250\">\r\n");
      out.write("<title>Privileges update form</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		try{
				if(!session.getAttribute("PRIVILEGES").equals("Adm")) {
					response.sendRedirect((String) session.getAttribute("REDIRECT"));
				}
		}
		catch(Exception e){
		}
	 
      out.write("\r\n");
      out.write("\t<div id=\"navel\">\r\n");
      out.write("        <div id=\"form\">\r\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UpDateServlet\" method=\"get\">\r\n");
      out.write("            \t<label>User:<select name=\"username\" id=\"username\">\r\n");
      out.write("            \t");

					List<Users> db = UserDbUtil.getUsers();
					
					for(Users user:db)
					{
						if(user.getUsername().equals("admin")){continue;}
						out.println("<option>"+user.getUsername()+"</option>");
					}
            	
      out.write("\r\n");
      out.write("            \t</select></label><br/>\r\n");
      out.write("            \t<input type=\"radio\" id=\"privileges\" name=\"privileges\" value=\"Bsc\" checked=\"checked\" /> Basic Privileges </br>\r\n");
      out.write("            \t<input type=\"radio\" id=\"privileges\" name=\"privileges\" value=\"Prm\" /> Premium Privileges </br>\r\n");
      out.write("            \t<input type=\"submit\" name=\"update\" value=\"Up Date\" />\r\n");
      out.write("            </form> \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
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
