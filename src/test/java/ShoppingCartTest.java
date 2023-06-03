import com.example.oop_project.GeneralGroceries;
import com.example.oop_project.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void totalToBePaid() {
        ShoppingCart SHTest = new ShoppingCart();
        SHTest.AddToCart(new GeneralGroceries("7mo",5.0,5));
        Assert.assertEquals(25.0 ,SHTest.TotalToBePaid(), 0.00001);
    }
}