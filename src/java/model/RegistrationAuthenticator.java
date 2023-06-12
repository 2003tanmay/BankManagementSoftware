package model;

import db.dbConnector;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aayush
 */
public class RegistrationAuthenticator {

    Connection con = null;
    PreparedStatement pst = null;

    public boolean isPhoneAlreadyRegistered(HttpServletRequest request, UserDTO user) {
        String mobileNumber = user.getMobileNumber();
        try {
            Connection con = dbConnector.getConnection();
            String query = "SELECT COUNT(*) FROM CustomerInformation WHERE Phone = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, mobileNumber);
            ResultSet resultSet = pst.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            request.setAttribute("registrationStatus", "failed");
            return count > 0;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    public boolean isRegistor(HttpServletRequest request, UserDTO user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String dateOfBirth = user.getDateOfBirth();
        String address = user.getAddress();
        String mobileNumber = user.getMobileNumber();
        String emailID = user.getEmailID();
        String accountType = user.getAccountType();
        String password = user.getPassword();

        CustomerIdGenerator cID = new CustomerIdGenerator();
        String customerId = cID.generateCustomerId();

        if (isPhoneAlreadyRegistered(request, user)) {
            return false;
        }
        try {
            con = dbConnector.getConnection();
            con.setAutoCommit(false);

            String query1 = "INSERT INTO CustomerInformation (CustomerID, FirstName, LastName, DateOfBirth, Address, Phone, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query1);
            pst.setString(1, customerId);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, dateOfBirth);
            pst.setString(5, address);
            pst.setString(6, mobileNumber);
            pst.setString(7, emailID);
            int i1 = pst.executeUpdate();

            String query2 = "INSERT INTO AccountInformation (CustomerID, AccountType, Balance, Password, OpeningDate) VALUES (?, ?, ?, ?, CURRENT_DATE())";
            pst = con.prepareStatement(query2);
            pst.setString(1, customerId);
            pst.setString(2, accountType);
            pst.setDouble(3, 00.00);
            pst.setString(4, password);
            int i2 = pst.executeUpdate();

            if (i1 > 0 && i2 > 0) {
                con.commit();
                request.setAttribute("registrationStatus", "success");
                request.setAttribute("customerID", customerId);
                return true;
            } else {
                con.rollback();
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;

    }
}
