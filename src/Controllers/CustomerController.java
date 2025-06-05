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

public class CustomerController {

    public CustomerController() {
    }

    public Customer findCustomerByEmail(String email) {
        Customer customer =
                CustomerContainer.getInstance().findCustomerByEmail(email);
        return customer;
    }
}
