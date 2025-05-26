package Containers;
import Enums.Status;
import Enums.Type;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private Type type;
    private String date;
    private Status status;
    private double totalAmount;
    private ArrayList<Product> products;
    private Customer customer;

    public double getTotalAmount() {
        return totalAmount;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }
}
