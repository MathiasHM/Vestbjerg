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
			return Result.MAXTHRESHOLDEXCEEDED;
		}
		else if (quantity < 1) { //TODO implementér logik til at fjerne instans.
			return Result.QUANTITYLESSTHANONE;
		}
		this.quantity = quantity;
		return Result.QUANTITYSET;
	}
	
	public Result changeQuantityBy(int quantityMod) {
		int q = quantity + quantityMod;
		if (q > product.getMaxThreshold()) {
			return Result.MAXTHRESHOLDEXCEEDED;
		}
		else if (q < 1) {		//TODO Kig op :)
			return Result.QUANTITYLESSTHANONE;
		}
		quantity = q;
		return Result.QUANTITYCHANGED;
	}
}