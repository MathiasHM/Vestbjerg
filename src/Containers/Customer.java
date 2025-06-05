/*
 * Customer.java
 *
 * This class represents a customer with an email and a CVR number.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

public class Customer {

    private String email;
    private int CVR;

    public Customer(String email, int CVR) {

        this.email = email;
        this.CVR = CVR;
    }

    public String getEmail() {
        return email;
    }

    public int getCVR() {
        return CVR;
    }
}
