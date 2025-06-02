package Containers;
import Enums.Status;
import Enums.Type;
import java.util.ArrayList;
import Containers.Line;
import Enums.Result;

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
    
    public double getTotalPrice() {								//TODO Implementér
    }

    public boolean setStatus(Status status) {
    	this.status = status;
    	return true;
    }
    
    
    public String displayLines() {								//TODO Implementér
    	
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
    
