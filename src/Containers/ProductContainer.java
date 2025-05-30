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
}