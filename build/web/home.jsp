<%-- 
    Document   : home
    Created on : Mar 26, 2023, 11:50:03 AM
    Author     : Aayush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body bgcolor="cyan">
        <a href="logout.jsp">Sign Out</a> <%-- for turning off session--%>
        <%
            //if someone directly jump to this page without login then it redirected to the login.html.  
            String customerID = (String) session.getAttribute("customerID"); //in jsp session is by default enabled.
            if (customerID == null || customerID.trim().equals("")) {
                response.sendRedirect("login.html");
            }
        %>
        <h1>Hello</h1>
        <form method="post" action="BalanceChecker">
            <input type="submit" value="Check Balance">
        </form>
        <%
            String balanceMessage = (String) request.getAttribute("balanceMessage");
            if (balanceMessage != null) {
                out.println("₹" + balanceMessage);
            }
        %>
        <form action="depositMoney.jsp">
            <button type="submit">Deposit Money</button>
        </form>
        <form action="withdrawalMoney.jsp">
            <button type="submit">Withdrawal Money</button>
        </form>
        <form action="statement.jsp">
            <button type="submit">Statement</button>
        </form>
    </body>
</html>
