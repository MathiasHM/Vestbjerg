/*
 * Order.java
 *
 * This class represents an order, containing relevant details such as the date, status, and lines of products.
 *
 * DMA-CSD-V252 group 5 first semester project
 */

package Containers;

import Enums.Result;
import Enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private LocalDateTime date; // Date of the order.
    // Time of day included in case of prices changing during the day.
    private Status status;
    private final ArrayList<Line> lines;
    private Customer customer;
    private Shipment shipment;

    public Order() {
        this.date =
                LocalDateTime.MIN;    //Start of UNIX time for error handling
        this.status = Status.PROCESSING;
        this.lines = new ArrayList<Line>();
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double[] getTotalPrice() {
        double[] totalPrice = new double[3];
        double sumOfPrices = 0;
        double discount = 0;
        for (Line l : lines) {
            sumOfPrices += l.getSubTotal();
        }

        if (customer != null) {
            if (customer.getCVR() != 0) { // If CVR is not zero, it's a business customer
                discount += 7.5;
            }
        }

        if (shipment == null) {
            discount += 5; // If no shipment information is provided, apply a 5% discount, should probably be a constant
        }

        if (discount > 20) {
            discount = 20; // Cap the discount at 20%, should probably be a constant
        }
        totalPrice[0] = sumOfPrices; // Total price before discount
        totalPrice[1] = discount; // Discount percentage

        sumOfPrices *= (100 - discount) / 100;

        totalPrice[2] = sumOfPrices; // Total price after discount
        return totalPrice;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public ArrayList<String> displayLines() {
        ArrayList<String> dLines = new ArrayList<>();
        for (Line l : lines) {
            dLines.add(l.displayInformation());
        }
        return dLines;
    }

    public Result addCustomer(Customer customer) {
        if (this.customer != null) {
            return Result.CUSTOMERALREADYASSOCIATED;
        }
        if (customer == null) {
            return Result.CUSTOMERNOTFOUND;
        }
        this.customer = customer;
        return Result.CUSTOMERADDED;
    }

    public Result addProduct(Product product, int quantity) {
        if (quantity <= 0) {                //Check for valid quantity
            return Result.QUANTITYLESSTHANONE;
        }
        if (product == null) {                //Check for valid product
            return Result.PRODUCTNOTFOUND;
        }
        for (Line l : lines) {                            //For-each loop
            if (l.getProduct()
                    .equals(product)) {        //Check product line exists
                return l.changeQuantityBy(quantity);    //Change quantity
            }
        }

        Line line = new Line(product,
                quantity);        //If line doesn't exist, create new line
        lines.add(
                line);                                //Add new line to ArrayList
        return Result.NEWLINECREATED;
    }

    public Result removeProduct(Product product, int quantity) {
        if (quantity <= 0) {                //Check for valid quantity
            return Result.QUANTITYLESSTHANONE;
        }
        if (product == null) {                //Check for valid product
            return Result.PRODUCTNOTFOUND;
        }
        for (Line l : lines) {
            if (l.getProduct().equals(product)) {
                return l.changeQuantityBy(-quantity);
            }
        }
        return Result.PRODUCTNOTFOUND;
    }

    public void setShippingInformation(String deliveryName,
                                       String deliveryAddress,
                                       String deliveryEmail) {
        if (shipment == null) {
            this.shipment =
                    new Shipment(deliveryName, deliveryAddress, deliveryEmail);
        } else {
            this.shipment.setInformation(deliveryName, deliveryAddress,
                    deliveryEmail);
        }
    }
}
    
