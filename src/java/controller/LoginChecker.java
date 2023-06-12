package controller;

import dto.CustomerDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;

/**
 *
 * @author Aayush
 */
public class LoginChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerID = request.getParameter("customerID");
        String password = request.getParameter("password");

        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerID(customerID);
        customer.setPassword(password);

        LoginAuthenticator authenticator = new LoginAuthenticator();
        boolean login = authenticator.isLogin(request, customer);

        String loginStatus = (String) request.getAttribute("loginStatus");
        if (login) {
            HttpSession session = request.getSession(true);
            session.setAttribute("customerID", customerID);

            if (loginStatus != null && loginStatus.equals("success")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            if (loginStatus != null && loginStatus.equals("failed")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
