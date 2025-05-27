package Containers;

public class Product {
    private int productID;
    private String name;
    private double price;
    private int stockTotal;
    private String category;
    private int minMaxThreshhold;
    
    public Product(int productID, String name, double price,
    		int stockTotal, String category, 
    		int minMaxThreshhold) {
    	this.productID = productID;
    	this.name = name;
    	this.price = price;
    	this.stockTotal = stockTotal;
    	this.category = category;
    	this.minMaxThreshhold = minMaxThreshhold;
    }
    
    public int getProductID() {
        return ProductID;
    }
}
