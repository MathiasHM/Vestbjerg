package Containers;
import Enums.Status;

import java.util.ArrayList;

import Enums.Result;

public class Order {
    private String date;
    private Status status;
    private double totalPrice;
    private ArrayList<Line> lines;
    private Customer customer;
    private Shipment shipment;
    
    public Order() {
        this.date = "1970-01-01";	//Preset error date
        this.status = Status.PROCESSING;
        this.lines = new ArrayList<Line>();	
        this.totalPrice = 0.0;
    }
    
    public void setDate(String date) {
    	this.date = date;
    }
    
    public double[] getTotalPrice() {
		double[] totalPrice = new double[3];
    	double sumOfPrices = 0; 
    	double discount = 0;
    	for (Line l : lines) {
    		sumOfPrices += l.getSubTotal();
    	}

		if (customer != null) {
			if (customer.getCVR() != 0) {
				discount += 7.5;
			}
		}
    	
    	if (shipment == null) {
    		discount += 5;
    	}
    	
    	if (discount > 20) {
    		discount = 20;
    	}
		totalPrice[0] = sumOfPrices; // Total price before discount
		totalPrice[1] = discount; // Discount percentage

    	sumOfPrices *= (100 - discount) / 100;

		totalPrice[2] = sumOfPrices; // Total price after discount
    	return totalPrice;
    }

    public void setStatus(Status status) {
    	this.status = status;
    }
    
    
    public ArrayList<String> displayLines() {
		ArrayList<String> dLines = new ArrayList<>();
		for (Line l : lines) {
			dLines.add(l.displayInformation());
		}
		return dLines;
    }
    
    public Result addCustomer(Customer customer) {
		if (this.customer != null) {
			return Result.CUSTOMERALREADYASSOCIATED;
		}
		if (customer == null) {
			return Result.CUSTOMERNOTFOUND;
		}
		this.customer = customer;
		return Result.CUSTOMERADDED;
    }
    
    public Result addProduct(Product product, int quantity) {
    	for (Line l : lines) {
    		if (l.getProduct().equals(product)) {
    			return l.changeQuantityBy(quantity);
    		}
    	}

    	Line line = new Line(product, quantity);
		lines.add(line);
    	return Result.NEWLINECREATED;
    }
    
    public Result removeProduct(Product product, int quantity) {
		for (Line l : lines) {
			if (l.getProduct().equals(product)) {
				return l.changeQuantityBy(- quantity);
			}
		}
		return Result.PRODUCTNOTFOUND;
    }
    
    public void setShippingInformation(String deliveryName, String deliveryAddress, String deliveryEmail) {
    	if (shipment == null) {
    		this.shipment = new Shipment(deliveryName, deliveryAddress, deliveryEmail);
    	}
    	else {
    		this.shipment.setInformation(deliveryName, deliveryAddress, deliveryEmail);
    	}
    }
}
    
