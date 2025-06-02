package Controllers;

import Containers.Order;
import Containers.OrderContainer;
import Enums.Status;
import Containers.Product;
import Enums.Result;
import Containers.Customer;

import java.time.LocalDateTime;

public class OrderController {
	
	private Order order;
	
	public OrderController() {
	}
	
    
	public void createOrder() {
		this.order = new Order();
		LocalDateTime nu = LocalDateTime.now();
		order.setDate(nu.toString());
	}
	
    public Result addProductByID(int productID, int quantity) {
    	ProductController pC = new ProductController();
    	Product product = pC.findProductByID(productID);
    	
    	Result result = this.order.addProduct(product, quantity);
    	return result;
    	//TODO error handling
    }
    
    public Result RemoveProductByID(int productID, int quantity) {
    	
    }
    
    public boolean setShippingInformation(String deliveryName, 
    		String deliveryAddress, String deliveryEmail) {
    	
    }
    
    public boolean addCustomerByEmail(String email) {
    	CustomerController cC = new CustomerController();
    	Customer customer = cC.findCustomerByEmail(email);
    	
    	boolean result = order.addCustomer(customer);
    	return result;
    }
    
    public double getTotalPrice() {
    	return order.getTotalPrice();
    }
    
    public boolean setOrderPending() {
    	order.setStatus(Status.PENDING);
    	order.setDate(LocalDateTime.now().toString());
    	return OrderContainer.getInstance().addOrder(order);
    }
}
