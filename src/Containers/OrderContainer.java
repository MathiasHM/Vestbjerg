/*
 * OrderContainer.java
 *
 * This class represents an order container, allowing for the management and retrieval of orders.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

import java.util.ArrayList;

public class OrderContainer {
    private static OrderContainer instance;
    private final ArrayList<Order> orders; //not used yet, but shows up in the debugger

    private OrderContainer() {
        orders = new ArrayList<>();
    }

    public static OrderContainer getInstance() {
        if (instance == null) {
            instance = new OrderContainer(); // Lazy initialization of the singleton instance
        }
        return instance;
    }

    public boolean addOrder(Order order) { //return value never used, but can be useful for testing
        if (order == null) {
            return false;
        }
        orders.add(order);
        return true;
    }
}