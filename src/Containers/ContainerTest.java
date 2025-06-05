package Containers;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    // Test for singleton behaviour of ProductContainer
    @Test
    public void productContainerSingletonAndListBehaviour() {
        ProductContainer pc1 = ProductContainer.getInstance();
        ProductContainer pc2 = ProductContainer.getInstance();
        assertSame(pc1, pc2);                      // singleton

        int start = pc1.getProducts().size();
        Product p = new Product(999, "Injected", 1.0, 1);

        pc1.getProducts().add(p);                  // list is modifiable
        assertEquals(start + 1, pc1.getProducts().size());
        assertEquals(p, pc1.findProductByID(999));
    }
}