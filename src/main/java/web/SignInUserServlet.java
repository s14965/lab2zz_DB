package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.UserDbUtil;
import domain.Users;

@WebServlet("/SignInUserServlet")
public class SignInUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException ,IOException {
        HttpSession session = request.getSession();

        try
        {
            Users user = doContain(request);
            session.setAttribute("PRIVILEGES", user.getPrivileges());
            if(session.getAttribute("PRIVILEGES").equals("Bsc")) {System.out.println(user.getPrivileges());}
            String redirect = user.getPrivileges() + "Panel.jsp"; //
            session.setAttribute("REDIRECT", redirect);
            response.sendRedirect(redirect);
        }
        catch(Exception e)
        {
        	session.setAttribute("SIGN_IN_ERROR", "Invalid username or password.");
            response.sendRedirect("signInForm.jsp");
        }

    }

    private Users doContain(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Users user = UserDbUtil.checkIfValid(username, password);
            if(user != null) {
                return user;
            }
            else {
                    return null;
            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }
}

