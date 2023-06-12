<%-- 
    Document   : logout
    Created on : Mar 26, 2023, 12:08:57 PM
    Author     : Aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
