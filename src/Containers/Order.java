package Containers;
import Enums.Status;
import Enums.Type;
import java.util.ArrayList;
import Containers.Line;

public class Order {
    private String date;
    private Status status;
    private double totalPrice;
    private ArrayList<Line> lines;
    private Customer customer;
    private Shipment shipment;
    
    public Order() {
    }
    
    public double getTotalPrice() {								//TODO Implementér
    	
    }

    public boolean setStatus(Status status) {
    	this.status = status;
    	return true;
    }
    
    
    public String displayLines() {								//TODO Implementér
    	
    }
    
    public int addProduct(Product product, int quantity) {
    	for (Line l : lines) {
    		if (l.getProduct().equals(product)) {
    			int result = l.changeQuantityBy(quantity);					//TODO Tjek resultat
    			if (result == 1) {
    				return 2;
    			}
    			else if (result == 0) {
    				return 3;
    			}
    		}
    	}
    	
    	Line line = new Line(product, quantity);
    	return 1;
    	
    }
    
    public int removeProduct(Product product, int quantity) {	//TODO Implementér
    	
    }
    
}
    
