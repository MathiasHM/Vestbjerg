package Containers;

import Enums.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    // Test for Line class functionality
    @Test
    public void increaseWithinThresholdReturnsQuantityChanged() {
        Product prod = new Product(1, "produkt", 50.0, 10);
        Line line = new Line(prod, 2);

        Result r = line.changeQuantityBy(+3);
        assertEquals(Result.QUANTITYCHANGED, r);
        assertEquals(250.0, line.getSubTotal(), 0.0001);
    }

    // Test for threshold limit
    @Test
    public void increaseAboveThresholdIsRejected() {
        Product prod = new Product(2, "også produkt", 20.0, 6);
        Line line = new Line(prod, 5);

        Result r = line.changeQuantityBy(+2); // would be 7 (max 6)
        assertEquals(Result.MAXTHRESHOLDEXCEEDED, r);
        assertEquals(100.0, line.getSubTotal(), 0.0001); // unchanged
    }

    //test for quantity decrease
    @Test
    public void decreaseToZeroReturnsLineRemoved() {
        Product prod = new Product(3, "jep, produkt", 10.0, 8);
        Line line = new Line(prod, 3);

        Result r = line.changeQuantityBy(-2);
        assertEquals(Result.QUANTITYCHANGED, r);
        assertEquals(10.0, line.getSubTotal(), 0.0001);
        r = line.changeQuantityBy(-2);
        assertEquals(Result.LINEREMOVED, r);
        assertEquals(0.0, line.getSubTotal(), 0.0001);
    }
}
