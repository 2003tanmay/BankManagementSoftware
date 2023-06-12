package controller;

import dto.CustomerDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BalanceFinder;

/**
 *
 * @author Aayush
 */
public class BalanceChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String customerID = (String) session.getAttribute("customerID");

        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerID(customerID);

        BalanceFinder finder = new BalanceFinder();
        String Balance = finder.isBalance(customer);

        request.setAttribute("balanceMessage", Balance);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);

    }
}
