package model;

import db.dbConnector;
import dto.CustomerDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aayush
 */
public class BalanceFinder {

    public String isBalance(CustomerDTO customer) {
        String customerID = customer.getCustomerID();
        String balance = "";

        try {
            Statement st = dbConnector.getStatement();
            String query = "select Balance from AccountInformation where CustomerID = '" + customerID + "'";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                balance = rs.getString(1);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return balance;
    }
}
