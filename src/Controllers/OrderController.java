package Controllers;

import Containers.Order;

public class OrderController {
    public void createOrder() {
        Order order = new Order();
    }
    public void addProductByProductID(int productId) {
        // Logic to add a product by its ID
    }
    public void removeProductByProductID(int productId) {
        // Logic to remove a product by its ID
    }
    public void findCustomerByCustomerId(String customerId) {
        // Logic to find a customer by their ID
    }
    public void setPrice() {
        // Logic to set the price of an order.
        // Remember to add discount
    }
    public void confirmOrder() {
        // Logic to confirm an order
    }
}
