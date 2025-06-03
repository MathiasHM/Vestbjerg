package Controllers;

import Containers.Product;
import Containers.ProductContainer;

public class ProductController {
	
	public ProductController() {	
	}
	
    public Product findProductByID(int productID) {
        return ProductContainer.getInstance().findProductByID(productID);
    }
}
