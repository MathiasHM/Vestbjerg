/*
 * CustomerController.java
 *
 * This class is a controller for managing customer-related operations.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Controllers;

import Containers.Customer;
import Containers.CustomerContainer;
import java.util.ArrayList;

public class CustomerController {

    public CustomerController() {
    }

    public Customer findCustomerByEmail(String email) {
        return CustomerContainer.getInstance().findCustomerByEmail(email);
    }

    public ArrayList<String> sortCustomersByEmail(String key) {
        ArrayList<String> emailList = new ArrayList<>();
        for (Customer c : CustomerContainer.getInstance().getCustomers()) {
            if (c.getEmail().toLowerCase().contains(key.toLowerCase())) {
                emailList.add(c.getEmail());
			}
        }
        return emailList;
    }
}
