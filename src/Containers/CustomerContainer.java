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
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}