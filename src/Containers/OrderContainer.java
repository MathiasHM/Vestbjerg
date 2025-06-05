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
    private ArrayList<Order> orders;

    private OrderContainer() {
        orders = new ArrayList<>();
    }

    public static OrderContainer getInstance() {
        if (instance == null) {
            instance = new OrderContainer();
        }
        return instance;
    }

    public boolean addOrder(Order order) {
        orders.add(order);
        return true;
    }
}