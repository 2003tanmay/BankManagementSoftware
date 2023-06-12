package controller;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegistrationAuthenticator;

/**
 *
 * @author Aayush
 */
public class RegisterChecker extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailID = request.getParameter("emailID");
        String accountType = request.getParameter("accountType");
        String password = request.getParameter("password");

        UserDTO user = new UserDTO();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dateOfBirth);
        user.setAddress(address);
        user.setMobileNumber(mobileNumber);
        user.setEmailID(emailID);
        user.setAccountType(accountType);
        user.setPassword(password);

        RegistrationAuthenticator authenticator = new RegistrationAuthenticator();
        boolean registor = authenticator.isRegistor(request, user);

        String registrationStatus = (String) request.getAttribute("registrationStatus");
        String customerId = (String) request.getAttribute("customerID");
        if (registor) {
            if (registrationStatus != null && registrationStatus.equals("success")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            if (registrationStatus != null && registrationStatus.equals("failed")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
