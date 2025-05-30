package Controllers;

import Containers.Customer;
import Containers.CustomerContainer;

public class CustomerController {
	
	public CustomerController() {
	}
	
    public Customer findCustomerByID(String customerID) {
        Customer customer = CustomerContainer.getInstance().findCustomerByEmail(customerID);
        return customer;
    }
}
