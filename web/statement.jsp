<%-- 
    Document   : statement
    Created on : Jun 3, 2023, 12:26:21 AM
    Author     : Aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statement Page</title>
    </head>
    <body>
        <h1>Statement</h1>
        <%
            //if someone directly jump to this page without login then it redirected to the login.html.  
            String customerID = (String) session.getAttribute("customerID"); //in jsp session is by default enabled.
            if (customerID == null || customerID.trim().equals("")) {
                response.sendRedirect("login.html");
            }
        %>
    </body>
</html>
