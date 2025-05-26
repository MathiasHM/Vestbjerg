package Containers;

import java.util.ArrayList;

public class ProductContainer {
    private static ProductContainer instance;
    private ArrayList<Product> products;

    private ProductContainer() {
        products = new ArrayList<>();
    }

    public static ProductContainer getInstance() {
        if (instance == null) {
            instance = new ProductContainer();
        }
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}