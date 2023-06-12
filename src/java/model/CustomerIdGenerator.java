package model;

import java.util.UUID;

/**
 *
 * @author Aayush
 */
public class CustomerIdGenerator {

    public String generateCustomerId() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 8);
    }
}
