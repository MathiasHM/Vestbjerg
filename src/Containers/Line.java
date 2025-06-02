package Containers;
import Enums.Result;

public class Line {
	
	private Product product;
	private int quantity;
	private double subTotal;
	
	public Line(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		calculateSubTotal();
	}

	private void calculateSubTotal() {
		this.subTotal = product.getPrice() * quantity;
	}
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getSubTotal() {
		return this.subTotal;
	}
	

	
	public Result setQuantity(int quantity) { 		
		if (quantity > product.getMaxThreshold()) {
			return Result.MAXTHRESHOLDEXCEEDED;
		}
		else if (quantity < 1) {
			this.product = null;
			this.quantity = 0;
			this.subTotal = 0;
			return Result.QUANTITYLESSTHANONE;
		}
		this.quantity = quantity;
		calculateSubTotal();
		return Result.QUANTITYSET;
	}
	
	public Result changeQuantityBy(int quantityMod) {
		int q = this.quantity + quantityMod;
		if (q > product.getMaxThreshold()) {
			return Result.MAXTHRESHOLDEXCEEDED;
		}
		else if (q < 1) {
			this.product = null;
			this.quantity = 0;
			this.subTotal = 0;
			return Result.QUANTITYLESSTHANONE;
		}
		this.quantity = q;
		calculateSubTotal();
		return Result.QUANTITYCHANGED;
	}
}