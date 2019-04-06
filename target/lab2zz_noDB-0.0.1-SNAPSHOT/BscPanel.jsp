<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page contentType="text/html" pageEncoding="windows-1250"%>
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
     	if(session.getAttribute("PRIVILEGES").equals("Bsc")) {
	 %>
     	<div style="float: left;"><a href="logout.jsp">Logout</a></div>
	    <div id="navel">
	    <h1>Basic user view </h1>
	  	 	
		</div>
	<%
		}
		else if(session.getAttribute("PRIVILEGES").equals("Adm") || session.getAttribute("PRIVILEGES").equals("Prm")) {
		response.sendRedirect((String) session.getAttribute("REDIRECT"));
		}
	}
	catch(Exception e) {
		response.sendRedirect("signInForm.jsp");
	}
	%>
	</body>
</html>