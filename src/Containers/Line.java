package Containers;
import Enums.Result;

public class Line {
	
	private Product product;
	private int quantity;
	
	public Line(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	

	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getSubTotal() {
		double subTotal = product.getPrice()*quantity;
		return subTotal;
	}
	
	public Result setQuantity(int quantity) { 		
		if (quantity > product.getMaxThreshold()) {
			return MAXTHRESHOLDEXCEEDED;
		}
		else if (quantity < 1) { //TODO implementér logik til at fjerne instans.
			return QUANTITYLESSTHANONE;
		}
		this.quantity = quantity;
		return 1;
	}
	
	public int changeQuantityBy(int quantityMod) {
		int q = quantity + quantityMod;
		if (q > product.getMaxThreshold()) {
			return 0;
		}
		else if (q < 1) {		//TODO Kig op :)
			return -1;
		}
		quantity = q;
		return 1;
	}
}