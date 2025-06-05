package Containers;

import Enums.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void addProductCreatesLineThenAccumulates() {
        Order   o   = new Order();
        Product p   = new Product(10, "Bolt", 25.0, 8);

        assertEquals(Result.NEWLINECREATED,   o.addProduct(p, 3));
        assertEquals(Result.QUANTITYCHANGED,  o.addProduct(p, 2));   // total 5

        double[] t = o.getTotalPrice();                     // [before , %, after]
        assertEquals(125.0, t[0], 0.0001);                  // 5 × 25
        assertEquals(5.0,   t[1], 0.0001);                  // no shipping discount
        assertEquals(118.75, t[2], 0.0001);
    }

    @Test
    public void addProductOverThresholdIsRejected() {
        Order   o = new Order();
        Product p = new Product(11, "hammer", 5.0, 6);

        assertEquals(Result.MAXTHRESHOLDEXCEEDED, o.addProduct(p, 7));
    }

    @Test
    public void removeAllUnitsReturnsQuantityLessThanOne() {
        Order   o = new Order();
        Product p = new Product(12, "skrue", 10.0, 10);

        o.addProduct(p, 4);
        assertEquals(Result.LINEREMOVED, o.removeProduct(p, 4));
    }

    @Test
    public void totalPriceAppliesDiscountRules() {
        Order   o = new Order();
        Product p = new Product(13, "testting", 100.0, 5);

        o.addProduct(p, 2);                                 // 200 before disc

        Customer c = new Customer("bizzness@corp.dk", 12345678); // CVR ≠ 0
        o.addCustomer(c);

        // CVR 7.5 %  +  missing-shipment 5 %  = 12.5 %
        double[] noShip = o.getTotalPrice();
        assertEquals(200.0, noShip[0], 0.0001);
        assertEquals(12.5, noShip[1], 0.0001);
        assertEquals(175.0, noShip[2], 0.0001);

        // add shipment → lose 5 % discount
        o.setShippingInformation("Bjårn Bjøærnsen", "gaden", "ship@place.dk");

        double[] withShip = o.getTotalPrice();
        assertEquals(200.0, withShip[0], 0.0001);
        assertEquals(7.5,  withShip[1], 0.0001);
        assertEquals(185.0, withShip[2], 0.0001);
    }
}