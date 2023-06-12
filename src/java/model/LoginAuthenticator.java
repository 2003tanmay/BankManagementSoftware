package model;

import db.dbConnector;
import dto.CustomerDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aayush
 */
public class LoginAuthenticator {

    public boolean isLogin(HttpServletRequest request, CustomerDTO customer) {
        String customerID = customer.getCustomerID();
        String password = customer.getPassword();
        String tablePassword = "";

        try {
            Statement st = dbConnector.getStatement();
            String query = "select Password from AccountInformation where CustomerID = '" + customerID + "'";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                tablePassword = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        if (customerID != null && password != null && !customerID.trim().equals("") && password.equals(tablePassword)) {
            request.setAttribute("loginStatus", "success");
            return true;
        }
        request.setAttribute("loginStatus", "failed");
        return false;
    }
}
