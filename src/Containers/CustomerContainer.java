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

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}