<%@page contentType="text/html" pageEncoding="windows-1250"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="utilStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>JSP Page</title>
    </head>
    <body>
    <div id="navel">
        <div id="form">
            <form action="SignUpServlet" method="POST">
                <label>Username: <input type="text" id="username" name="username"/></label><br/><br/>
                <label>Password: <input type="text" id="password" name="password"/></label><br/><br/>
                <label>Confirm Password: <input type="text" id="password" name="confirmPassword"/></label><br/><br/>
                <label>Email: <input type="text" id="email" name="email"/></label><br/><br/>
                <input type="submit" value="Sign Up"/>
            </form>
            
        </div>
    </div>
    </body>
</html>
