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
    
    public Order(int orderID, Type type, String date, 
    		Status status, double totalAmount,
    		ArrayList<Product> products, Customer customer) {
    	this.orderID = orderID;
    	this.type = type;
    	this.date = date;
    	this.status = status;
    	this.totalAmount = totalAmount;
    	this.products = products;
    	this.customer = customer;    	
    	
    }

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
