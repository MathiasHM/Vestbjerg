package Containers;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int stockTotal;
    private String category;
    private int maxThreshhold;
    
    public Product(int productID, String name, double price,
    		int stockTotal, String category, 
    		int maxThreshhold) {
    	this.productID = productID;
    	this.name = name;
    	this.price = price;
    	this.stockTotal = stockTotal;
    	this.category = category;
    	this.maxThreshhold = maxThreshhold;
    }
    
    public int getID() {
        return productID;
    }
}
