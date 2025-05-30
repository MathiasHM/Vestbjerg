package Controllers;

import Containers.Product;
import Containers.ProductContainer;

public class ProductController {
	
	public ProductController() {	
	}
	
    public Product findProductByID(int productID) {
        Product p = ProductContainer.getInstance().findProductByID(productID);
        return p;
    }
}
