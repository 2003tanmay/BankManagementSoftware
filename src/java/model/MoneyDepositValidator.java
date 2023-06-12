package model;

import db.dbConnector;
import dto.TransactionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aayush
 */
public class MoneyDepositValidator {

    private boolean isAmountValid(double amountNumber) {
        return amountNumber <= 10000 && amountNumber >= 1;
    }

    Connection con = null;
    PreparedStatement pst = null;

    public boolean isDeposit(HttpServletRequest request, TransactionDTO transaction) {
        String customerID = transaction.getCustomerID();
        String password = transaction.getPassword();
        String amount = transaction.getAmount();
        String transactionType = "Credit";
        String tablePassword = "";
        String accountNumber = "";
        double balance = 0.0;
        double amountNumber = Double.parseDouble(amount);

        if (isAmountValid(amountNumber) == false) {

            request.setAttribute("moneyDepositStatus", "failed");

            return false;
        }

        TransactionIdGenerator tID = new TransactionIdGenerator();
        String transactionId = tID.generateTransactionID();

        try {
            con = dbConnector.getConnection();
            String query = "select Password from AccountInformation where CustomerID = ?";
            System.out.println("Query = " + query);
            pst = con.prepareStatement(query);
            pst.setString(1, customerID);
            System.out.println("? filled");
            ResultSet rs = pst.executeQuery();
            System.out.println("query executed");
            if (rs.next()) {
                tablePassword = rs.getString("Password");
            }

            if (customerID != null && password != null && !customerID.trim().equals("") && password.equals(tablePassword)) {
                try {
                    // Select Account Number query
                    String query1 = "SELECT AccountNumber FROM AccountInformation WHERE CustomerID = ?";
                    pst = con.prepareStatement(query1);
                    pst.setString(1, customerID);
                    ResultSet accountNumberResult = pst.executeQuery();
                    if (accountNumberResult.next()) {
                        accountNumber = accountNumberResult.getString("AccountNumber");
                    }
                    pst.close();

                    // Select Balance query
                    String query2 = "SELECT Balance FROM AccountInformation WHERE CustomerID = ?";
                    pst = con.prepareStatement(query2);
                    pst.setString(1, customerID);
                    ResultSet balanceResult = pst.executeQuery();
                    if (balanceResult.next()) {
                        balance = balanceResult.getDouble("Balance");
                    }
                    pst.close();

                    // Update Balance query
                    String query3 = "UPDATE AccountInformation SET Balance = Balance + ? WHERE AccountNumber = ?";
                    pst = con.prepareStatement(query3);
                    pst.setDouble(1, amountNumber);
                    pst.setString(2, accountNumber);
                    int updateBalanceCount = pst.executeUpdate();
                    pst.close();

                    // Insert Transaction query
                    String query4 = "INSERT INTO TransactionInformation (TransactionId, AccountNumber, TransactionType, Amount, TransactionDateTime, TotalBalance) VALUES (?, ?, ?, ?, NOW(), ?)";
                    pst = con.prepareStatement(query4);
                    pst.setString(1, transactionId);
                    pst.setString(2, accountNumber);
                    pst.setString(3, transactionType);
                    pst.setDouble(4, amountNumber);
                    pst.setDouble(5, balance + amountNumber);
                    int insertTransactionCount = pst.executeUpdate();
                    pst.close();

                } catch (SQLException e) {
                    System.out.println(e);
                } finally {
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            System.err.println(e);
                        }
                    }
                    if (pst != null) {
                        try {
                            pst.close();
                        } catch (SQLException e) {
                            System.err.println(e);
                        }
                    }
                }

                request.setAttribute("moneyDepositStatus", "success");

                return true;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }
}
