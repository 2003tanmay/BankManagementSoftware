<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="CSS/index.css" type="text/css"/>
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
                            <li><a class="main-link" href="#register">Register</a></li>
                            <li><a class="other-link" href="index.html">Home</a></li>
                            <li><a class="other-link" href="login.jsp">Login</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="Background">
            <div class="background-left">
                <div class="form">
                    <%
                        String registrationStatus = (String) request.getAttribute("registrationStatus");
                        if (registrationStatus != null && registrationStatus.equals("failed")) {
                            out.println("<p>Phone number already exists. Registration unsuccessful.</p>");
                        }
                    %>
                    <form action="RegisterChecker" method="post">
                        <table>
                            <tr>
                                <td>First Name:</td>
                                <td><input type="text" id="firstName" name="firstName" placeholder="Enter First Name" required></td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td><input type="text" id="lastName" name="lastName" placeholder="Enter Last Name" required></td>
                            </tr>
                            <tr>
                                <td>Date of Birth:</td>
                                <td><input type="date" id="dateOfBirth" name="dateOfBirth" placeholder="Enter Date of Birth" pattern="\d{4}-\d{2}-\d{2}" required></td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td><input type="text" id="address" name="address" placeholder="Enter Address" required></td>
                            </tr>
                            <tr>
                                <td>Mobile Number:</td>
                                <td><input type="text" id="mobileNumber" name="mobileNumber" placeholder="Enter Mobile Number" required></td>
                            </tr>
                            <tr>
                                <td>Email ID:</td>
                                <td><input type="text" id="emailID" name="emailID" placeholder="Enter Email ID" required></td>
                            </tr>
                            <tr>
                                <td>Account Type:</td>
                                <td>
                                    <select id="accountType" name="accountType">
                            <option value="saving">Saving</option>
                            <option value="current">Current</option>
                            <option value="salary">Salary</option>
                        </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" id="password" name="password" placeholder="Enter Password" required></td>
                            </tr>
                            <tr>
                                <td>First Name::</td>
                                <td><input type="submit" value="Register" style="background-color: #4570A0; color: white; border: none; border-radius: 2px"></td>
                            </tr>
                        </table>
                    </form>

                    <p><a href="login.jsp">Already a User?</a></p>
                </div>
            </div>
            <div class="background-right">
            </div>
        </div>
    </body>
</html>

