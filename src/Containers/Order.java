package Containers;
import Enums.Status;
import Enums.Type;
import java.util.ArrayList;
import Containers.Line;
import Enums.Result;

import java.lang.StringBuilder;

public class Order {
    private String date;
    private Status status;
    private double totalPrice;
    private ArrayList<Line> lines;
    private Customer customer;
    private Shipment shipment;
    
    public Order() {
        this.date = "1970-01-01";
        this.status = Status.PROCESSING;
        this.lines = new ArrayList<>();
        this.totalPrice = 0.0;
    }
    
    public void setDate(String date) {
    	this.date = date;
    }
    
    public double getTotalPrice() {	
    	double sumOfPrices = 0; 
    	double discount = 0;
    	for (Line l : lines) {
    		sumOfPrices += l.getSubTotal();
    	}
    	
    	if (customer.getCVR() != null) {
    		discount += 7.5;
    	} // PRIVAT KUNDE CVR ATTRIBUT SKAL SÆTTES TIL NULL.
    	
    	if (shipment == null) {
    		discount += 5;
    	}
    	
    	if (discount > 20) {
    		discount = 20;
    	} 
    	
    	sumOfPrices *= (100-discount)/100;
    	totalPrice = sumOfPrices;
    	return totalPrice;
    }

    public boolean setStatus(Status status) {
    	this.status = status;
    	return true;
    }
    
    
    public ArrayList<String> displayLines() {	
    	StringBuilder sb = new StringBuilder();
    	for (Line l : lines) {
    		String lineUI = (String) l.getSubTotal();
    		sb.append("Line subtotal: ".append(lineUI)
    		.append(", productID: ").append(l.getProduct().getID())
    		.append(", product name: ").append(l.getProduct().getName()));
    	}
    	
    }
    
    public boolean addCustomer(Customer customer) {
    	this.customer = customer;
    	return true;
    }
    
    public Result addProduct(Product product, int quantity) {
    	for (Line l : lines) {
    		if (l.getProduct().equals(product)) {
    			Result result = l.changeQuantityBy(quantity);					//TODO Tjek resultat
    			return result;
    		}
    	}
    	
    	Line line = new Line(product, quantity);
    	return Result.NEWLINECREATED;
    }
    
    public int removeProduct(Product product, int quantity) {	//TODO Implementér
    	
    }
    
}
    
