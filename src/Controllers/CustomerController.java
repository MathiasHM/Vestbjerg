package Controllers;

import Containers.Customer;
import Containers.CustomerContainer;

public class CustomerController {
	
	public CustomerController() {
	}
	
    public Customer findCustomerByEmail(String email) {
        Customer customer = CustomerContainer.getInstance().findCustomerByEmail(email);
        return customer;
    }
}
