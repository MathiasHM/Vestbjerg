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