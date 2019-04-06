<%@page import="domain.UserDbUtil"%>
<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@page import="java.util.List, domain.Users, java.io.PrintWriter;" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="utilStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    try{
   		if(session.getAttribute("PRIVILEGES").equals("Adm")) {
	 %>
	    <div style="float: left;">
	    <a href="/upDatePrivileges.jsp">Edit Privileges</a><br/>
	    <a href="logout.jsp">Logout</a>
	    </div>
	    <div id="navel">
		
			<table border='1'>
				<tr>
					<td>Username</td>
					<td>Password</td>
					<td>Email</td>
					<td>Privileges</td>
				</tr>
				<%
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
				%>
				
			</table><br />
			
		</div>
	<%
		}
		else if(session.getAttribute("PRIVILEGES").equals("Bsc") || session.getAttribute("PRIVILEGES").equals("Prm")) {
			response.sendRedirect((String) session.getAttribute("REDIRECT"));
		}
	 }
	catch(Exception e) {
		response.sendRedirect("signInForm.jsp");
	}
	%>
	</body>
</html>