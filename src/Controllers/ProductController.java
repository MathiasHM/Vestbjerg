/*
 * ProductController.java
 *
 * This class is a controller for managing product-related operations.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

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
