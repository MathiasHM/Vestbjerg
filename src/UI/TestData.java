package UI;

import Containers.Customer;
import Containers.CustomerContainer;
import Containers.Product;
import Containers.ProductContainer;

public class TestData {
    public void generateTestData() {
        // Generate test customers
        CustomerContainer customerContainer = CustomerContainer.getInstance();
        customerContainer.getCustomers().add(new Customer("business@gmail.com", 12345678));
        customerContainer.getCustomers().add(new Customer("kunde@gmail.com", 0)); // No CVR for consumer

        // Generate test products
        ProductContainer productContainer = ProductContainer.getInstance();
        productContainer.getProducts().add(new Product(1, "Skruetrækker", 50.00, 10, "Skruetrækkere",
        30));
    }
}