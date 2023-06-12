package controller;

import dto.TransactionDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MoneyWithdrawalValidator;

/**
 *
 * @author Aayush
 */
public class MoneyDrawer extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String customerID = (String) session.getAttribute("customerID");

        String amount = request.getParameter("amount");
        String password = request.getParameter("password");

        TransactionDTO transaction = new TransactionDTO();
        transaction.setCustomerID(customerID);
        transaction.setPassword(password);
        transaction.setAmount(amount);

        MoneyWithdrawalValidator validator = new MoneyWithdrawalValidator();
        boolean withdrawal = validator.isWithdrawal(request, transaction);
        
        System.out.println("balance insufficent in servlet");
        
        String moneyWithdrawalStatus = (String) request.getAttribute("moneyWithdrawalStatus");
        String balanceInsufficient = (String) request.getAttribute("balanceInsufficient");
        if (withdrawal) {
            if (moneyWithdrawalStatus != null && moneyWithdrawalStatus.equals("success")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("withdrawalMoney.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            if (balanceInsufficient != null && balanceInsufficient.equals("failed")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("withdrawalMoney.jsp");
                dispatcher.forward(request, response);
            }
            if (moneyWithdrawalStatus != null && moneyWithdrawalStatus.equals("failed")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("withdrawalMoney.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
