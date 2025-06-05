/*
 * ProductContainer.java
 *
 * This class represents a product container, allowing for the management and retrieval of products.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

import java.util.ArrayList;

public class ProductContainer {
    private static ProductContainer instance;
    private ArrayList<Product> products;

    private ProductContainer() {
        products = new ArrayList<Product>();
    }

    public static ProductContainer getInstance() {
        if (instance == null) {
            instance = new ProductContainer();
        }
        return instance;
    }

    public Product findProductByID(int productID) {
        for (Product p : products)
            if (p.getID() == productID) {
                return p;
            }
        return null;
    }

    public ArrayList<Product> getProducts() { //Ikke en del af usecasen men til test
        return products;
    }
}