package Containers;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int maxThreshold;
    
    public Product(int productID, String name, double price,
    		int maxThreshold) {
    	this.productID = productID;
    	this.name = name;
    	this.price = price;
    	this.maxThreshold = maxThreshold;
    }
    
    public int getID() {
        return productID;
    }

    public String getName() {
        return name;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public int getMaxThreshold() {
    	return maxThreshold;
    }
}
