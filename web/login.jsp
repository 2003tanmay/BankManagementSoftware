<%-- 
    Document   : login
    Created on : Jun 4, 2023, 5:00:43 PM
    Author     : Aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/index.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="Navbar-layout">
            <div class="Navbar">
                <div class="Nav-left">
                    <div class="logo"></div>
                </div>
                <div class="Nav-mid">

                </div>
                <div class="Nav-right">
                    <div class="nav-menu">
                        <ul class="nav-name">
                            <li><a class="main-link" href="#login">Login</a></li>
                            <li><a class="other-link" href="index.html">Home</a></li>
                            <li><a class="other-link" href="register.jsp">Register</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="Background">
            <div class="background-left">
                <div>
                    <%
                        String customerID = (String) request.getAttribute("customerID");
                        String registrationStatus = (String) request.getAttribute("registrationStatus");
                        String loginStatus = (String) request.getAttribute("loginStatus");
                        if (customerID != null && registrationStatus != null && registrationStatus.equals("success")) {%>
                    <p>Registration successful. Your Customer ID is: <%= customerID%></p>
                    <%  }
                        if (loginStatus != null && loginStatus.equals("failed")) {
                            out.println("Login failed...! Please check your credentials.");
                        }
                    %>
                    <form action="LoginChecker" method="post"> <!--Whenever a form is submit a data it send it to a servlet.-->
                        <table>
                            <tr>
                                <td>Customer ID:</td>
                                <td><input type="text" name="customerID" placeholder="Enter Customer ID"></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="text" name="password" placeholder="Enter password"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Login" style="background-color: #4570A0; color: white; border: none; border-radius: 2px"></td>
                            </tr>
                        </table>
                    </form>
                    <a href="register.jsp">New User?</a>
                </div>
            </div>
            <div class="background-right">
            </div>
        </div>
    </body>
</html>
