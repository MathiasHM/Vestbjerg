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
	}
	
    public Result addProductByID(int productID, int quantity) {
    	ProductController pC = new ProductController();
    	Product product = pC.findProductByID(productID);
    	
    	Result result = this.order.addProduct(product, quantity);
    	return result;
	}
    
    public Result removeProductByID(int productID, int quantity) {
    	ProductController pC = new ProductController();
    	Product product = pC.findProductByID(productID);
    	
    	Result result = order.removeProduct(product, quantity);
    	return result;
    }
    
    public void setShippingInformation(String deliveryName, 
    		String deliveryAddress, String deliveryEmail) {
    	order.setShippingInformation(deliveryName, deliveryAddress, deliveryEmail);
    }
    
    public Result addCustomerByEmail(String email) {
    	CustomerController cC = new CustomerController();
    	Customer customer = cC.findCustomerByEmail(email);
    	return order.addCustomer(customer);
    }
    
    public double getTotalPrice() {
    	return order.getTotalPrice();
    }

	public String[] displayLines() {
		return order.displayLines().toArray(new String[0]);
	}
    public void setOrderPending() {
    	order.setStatus(Status.PENDING);
    	order.setDate(LocalDateTime.now().toString());
    }
}
