import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    Logger logger = LogManager.getRootLogger();

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        if(!(components.length==4))
        {
            ArrayIndexOutOfBoundsException limitExceeded= new ArrayIndexOutOfBoundsException("limit exceeded");
            logger.info(limitExceeded.getMessage());
            throw limitExceeded;
        }
        if (!components[2].matches("^(.+)@(\\S+)$")) {
            IllegalArgumentException wrongEmailFormat = new IllegalArgumentException("wrong format email");
            logger.info(wrongEmailFormat.getMessage());
            throw wrongEmailFormat;
        }
        if (!components[3].matches("[+7][0-9]{11}")) {
            IllegalArgumentException wrongPhoneFormat = new IllegalArgumentException("wrong format number");
            logger.info(wrongPhoneFormat.getMessage());
            throw wrongPhoneFormat;
        }
    }


    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}