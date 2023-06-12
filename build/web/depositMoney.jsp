<%-- 
    Document   : deposite
    Created on : Jun 3, 2023, 12:24:40 AM
    Author     : Aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit Money Page</title>
    </head>
    <body>
        <h1>Hello deposit</h1>
        <%
            //if someone directly jump to this page without login then it redirected to the login.html.  
            String customerID = (String) session.getAttribute("customerID"); //in jsp session is by default enabled.
            String moneyDepositStatus = (String) request.getAttribute("moneyDepositStatus");
            if (customerID == null || customerID.trim().equals("")) {
                response.sendRedirect("login.html");
            }
            if (moneyDepositStatus != null && moneyDepositStatus.equals("failed")) {
                out.println("Error..! Amount should be in between 0 to 10001 .");
            }
            if (moneyDepositStatus != null && moneyDepositStatus.equals("success")) {
                out.println("Amount credited to your account successfully.");
            }
        %>
        <form action="MoneyDepositor" method="post"> <!--Whenever a form is submit a data it send it to a servlet.-->
            <table>
                <tr>
                    <td>Amount:</td>
                    <td><input type="text" name="amount" placeholder="Enter Amount"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" placeholder="Enter password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Deposit"></td>
                </tr>
            </table>
        </form>
        <h3><a href="home.jsp">home page</a></h3>
    </body>
</html>
