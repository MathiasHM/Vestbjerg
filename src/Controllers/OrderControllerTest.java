package Controllers;

import UI.TestData;
import Enums.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {

    // Path: create - add product - add customer - price calc
    @Test
    public void fullOrderFlowWithDiscounts() {
        new TestData().generateTestData();                 // products + customers

        OrderController oc = new OrderController();
        oc.createOrder();

        assertEquals(Result.NEWLINECREATED, oc.addProductByID(1, 2));

        assertEquals(Result.CUSTOMERADDED,
                     oc.addCustomerByEmail("business@gmail.com"));

        double[] price = oc.getTotalPrice();
        assertAll(
            () -> assertEquals(200.0, price[0], 0.01),     // 2×100
            () -> assertEquals(12.5,  price[1], 0.01),     // 7.5 % + 5 % (no ship)
            () -> assertEquals(175.0, price[2], 0.01)
        );
    }

    // Removing everything yields LINEREMOVED
    @Test
    public void removeAllUnitsFlagsEmpty() {
        new TestData().generateTestData();
        OrderController oc = new OrderController();
        oc.createOrder();
        oc.addProductByID(2, 1);                           // any valid product

        assertEquals(Result.LINEREMOVED,
                     oc.removeProductByID(2, 1));
    }

    // Adding an excessive amount is blocked
    @Test
    public void addOverMaxThresholdRejected() {
        new TestData().generateTestData();
        OrderController oc = new OrderController();
        oc.createOrder();

        assertEquals(Result.MAXTHRESHOLDEXCEEDED,
                     oc.addProductByID(2, 999));           // threshold is 5
    }
}
