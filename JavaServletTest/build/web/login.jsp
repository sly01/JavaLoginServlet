<%-- 
    Document   : login
    Created on : 10.Tem.2013, 10:09:33
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
    <form method="post" action="checkServlet">
        <table>
            <tr><td>UserName</td><td><input type="text" name="username" /></td></tr>
            <tr><td>Password</td><td><input type="password" name="password"/></td></tr>
            <tr><td colspan="2"><input type="submit" value="Done"/></td><td></td></tr>
        </table>
    </form>
</body>
</html>
