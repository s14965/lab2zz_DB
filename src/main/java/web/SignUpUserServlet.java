package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import domain.UserDbUtil;


@WebServlet("/SignUpUserServlet")
public class SignUpUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException
	{
		HttpSession session = request.getSession();
		
		try {
			if(UserDbUtil.checkDoesUserExist((request).getParameter("username"))) {
				session.setAttribute("SIGN_UP_ERROR", "User already exists.");
				response.sendRedirect("signUpForm.jsp");
			}
			else {
				String signUpUsername = request.getParameter("username");
				String signUpPassword = request.getParameter("password"); 
				String signUpEmail = request.getParameter("email");
				UserDbUtil.addNewUser(signUpUsername, signUpPassword, signUpEmail);
				response.sendRedirect("signInForm.jsp");
			}
		}
		catch(Exception e) {
			session.setAttribute("SIGN_UP_ERROR", "Something went wrong.");
			response.sendRedirect("signUpForm.jsp");
		}
	
	}
}

