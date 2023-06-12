package model;

import java.util.UUID;

/**
 *
 * @author Aayush
 */
public class TransactionIdGenerator {

    public String generateTransactionID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 11);
    }
}
