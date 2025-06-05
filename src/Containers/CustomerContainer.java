/*
 * CustomerContainer.java
 *
 * This class represents a container for customers, allowing for the management and retrieval of customer data.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

import java.util.ArrayList;

public class CustomerContainer {
    private static CustomerContainer instance;
    private ArrayList<Customer> customers;

    private CustomerContainer() {
        customers = new ArrayList<>();
    }

    public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }

    public Customer findCustomerByEmail(String customerEmail) {
        for (Customer customer : customers)
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        return null;
    }

    public ArrayList<Customer> getCustomers() { //Ikke en del af usecasen men til test
        return customers;
    }
}