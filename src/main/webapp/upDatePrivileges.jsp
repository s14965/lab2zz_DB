<%@page import="domain.UserDbUtil"%>
<%@page contentType="text/html" pageEncoding="windows-1250"%>
<%@page import="java.util.List, domain.Users, java.io.PrintWriter;" %>
<!DOCTYPE html>
<html>
<head>
 		<link rel="stylesheet" type="text/css" href="utilStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
<title>Privileges update form</title>
</head>
<body>
	<%
		try{
				if(!session.getAttribute("PRIVILEGES").equals("Adm")) {
					response.sendRedirect((String) session.getAttribute("REDIRECT"));
				}
		}
		catch(Exception e){
		}
	 %>
	<div id="navel">
        <div id="form">
            <form action="${pageContext.request.contextPath}/UpDateServlet" method="get">
            	<label>User:<select name="username" id="username">
            	<%
					List<Users> db = UserDbUtil.getUsers();
					
					for(Users user:db)
					{
						if(user.getUsername().equals("admin")){continue;}
						out.println("<option>"+user.getUsername()+"</option>");
					}
            	%>
            	</select></label><br/>
            	<input type="radio" id="privileges" name="privileges" value="Bsc" checked="checked" /> Basic Privileges </br>
            	<input type="radio" id="privileges" name="privileges" value="Prm" /> Premium Privileges </br>
            	<input type="submit" name="update" value="Up Date" />
            </form> 
        </div>
    </div>
</body>
</html>