/*
 * OrderController.java
 *
 * This class is a controller for managing order-related operations.
 * Currently, it allows for the creation of orders, adding and removing products,
 * setting shipping information, adding customers, calculating total prices,
 * displaying order lines, and setting the order status to pending,
 * as an integral part of the "Create Order" use case.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Controllers;

import Containers.Customer;
import Containers.Order;
import Containers.OrderContainer;
import Containers.Product;
import Enums.Result;
import Enums.Status;

import java.time.LocalDateTime;

public class OrderController {

    private Order order;

    public OrderController() {
    }


    public void createOrder() {
        this.order = new Order();
    }

    public Result addProductByID(int productID, int quantity) {
        if (quantity <= 0) {
            return Result.QUANTITYLESSTHANONE;
        }
        ProductController pC = new ProductController();
        Product product = pC.findProductByID(productID);
        if (product == null) {
            return Result.PRODUCTNOTFOUND;
        }
        return this.order.addProduct(product, quantity);
    }

    public Result removeProductByID(int productID, int quantity) {
        if (quantity <= 0) {
            return Result.QUANTITYLESSTHANONE;
        }
        ProductController pC = new ProductController();
        Product product = pC.findProductByID(productID);
        if (product == null) {
            return Result.PRODUCTNOTFOUND;
        }
        return order.removeProduct(product, quantity);
    }

    public void setShippingInformation(String deliveryName,
                                       String deliveryAddress,
                                       String deliveryEmail) {
        order.setShippingInformation(deliveryName, deliveryAddress,
                deliveryEmail);
    }

    public Result addCustomerByEmail(String email) {
        CustomerController cC = new CustomerController();
        Customer customer = cC.findCustomerByEmail(email);
        return order.addCustomer(customer);
    }

    public double[] getTotalPrice() {
        return order.getTotalPrice();
    }

    public String[] displayLines() {
        return order.displayLines().toArray(new String[0]);
    }

    public void setOrderPending() {
        order.setStatus(Status.PENDING);
        order.setDate(LocalDateTime.now());
        OrderContainer.getInstance().addOrder(order);
    }
}
