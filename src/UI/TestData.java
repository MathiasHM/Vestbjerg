/*
 * TestData.java
 *
 * This class is a utility for generating test data for customers and products.
 * It ensures that test data is only generated once to avoid duplication.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package UI;

import Containers.Customer;
import Containers.CustomerContainer;
import Containers.Product;
import Containers.ProductContainer;

public class TestData {
    private boolean isTestDataGenerated = false;
    public void generateTestData() {
        if (isTestDataGenerated) {
            return;
        }
        // Generate test customers
        CustomerContainer customerContainer = CustomerContainer.getInstance();
        customerContainer.getCustomers().add(new Customer("business@gmail.com", 12345678));
        customerContainer.getCustomers().add(new Customer("kunde@gmail.com", 0)); // No CVR for consumer

        // Generate test products
        ProductContainer productContainer = ProductContainer.getInstance();
        productContainer.getProducts().add(new Product(1, "Sonisk Skruetrækker", 100.00, 13));
        productContainer.getProducts().add(new Product(2, "Bagvendt Boremaskine", 200.00, 5));
        productContainer.getProducts().add(new Product(3, "Højrehånds Hammer", 150.00, 20));
        productContainer.getProducts().add(new Product(4, "Laser Målestok", 499.99, 10));
        productContainer.getProducts().add(new Product(5, "1000 bier", 20, 10000));
        productContainer.getProducts().add(new Product(6, "Monopol Magnet", 1000000.0087594, 1));
        isTestDataGenerated = true;
    }
}