/*
 * Line.java
 *
 * This class represents a line item in an order, containing a product, its quantity,
 * and the subtotal for that line.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

import Enums.Result;

import java.text.NumberFormat;
import java.util.Locale;

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

    public double getSubTotal() {
        return this.subTotal;
    }

    public Result changeQuantityBy(int quantityMod) {
        int q = this.quantity + quantityMod;
        if (q > product.getMaxThreshold()) {
            return Result.MAXTHRESHOLDEXCEEDED;
        } else if (q < 1) {
            this.product = null;
            this.quantity = 0;
            this.subTotal = 0;
            return Result.QUANTITYLESSTHANONE;
        }
        this.quantity = q;
        calculateSubTotal();
        return Result.QUANTITYCHANGED;
    }

    public String displayInformation() {
        return this.product.getName() + "/" + this.product.getID() + "/" + NumberFormat.getCurrencyInstance(new Locale("da", "DK")).format(this.product.getPrice()) + "/" + this.quantity + "/" + NumberFormat.getCurrencyInstance(new Locale("da", "DK")).format(this.subTotal);
    }
}