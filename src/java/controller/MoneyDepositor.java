package controller;

import dto.TransactionDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MoneyDepositValidator;

/**
 *
 * @author Aayush
 */
public class MoneyDepositor extends HttpServlet {

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

        MoneyDepositValidator validator = new MoneyDepositValidator();
        boolean deposit = validator.isDeposit(request, transaction);

        String moneyDepositStatus = (String) request.getAttribute("moneyDepositStatus");
        if (deposit) {
            if (moneyDepositStatus != null && moneyDepositStatus.equals("success")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("depositMoney.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            if (moneyDepositStatus != null && moneyDepositStatus.equals("failed")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("depositMoney.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
