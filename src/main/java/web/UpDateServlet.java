package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.UserDbUtil;


@WebServlet("/UpDateServlet")
public class UpDateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException
	{
		
		try {
			String UpDateUsername = request.getParameter("username");
			String UpDatePrivileges = request.getParameter("privileges");
			UserDbUtil.UpDatePrivileges(UpDateUsername, UpDatePrivileges);
			response.sendRedirect("AdmPanel.jsp");
		}
		catch(Exception e) {
			
		}
	
	}
}

