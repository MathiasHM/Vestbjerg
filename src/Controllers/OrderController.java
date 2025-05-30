package Controllers;

import Containers.Order;
import Enums.Status;
import Containers.Product;

public class OrderController {
	
	private Order order;
	
	public OrderController() {
	}
	
    
	public void createOrder() {
		this.order = new Order();
	}
	
    public int addProductByID(int productID, int quantity) {
    	ProductController pC = new ProductController();
    	Product product = pC.findProductByID(productID);
    	
    	int result = this.order.addProduct(product, quantity);
    	return result;
    	//TODO fejlmeddelelser.
    }
    
    
}
