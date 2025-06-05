package Containers;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    // Test for singleton behaviour of ProductContainer
    @Test
    public void productContainerSingletonAndListBehaviour() {
        ProductContainer pc1 = ProductContainer.getInstance();
        ProductContainer pc2 = ProductContainer.getInstance();
        assertSame(pc1, pc2); // singleton
    }
}