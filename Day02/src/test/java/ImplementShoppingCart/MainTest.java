package ImplementShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5, 3);
        cart.addProduct("Banana", 0.8, 5);
        cart.addProduct("Cherry", 2.0, 2);
    }

    @Test
    void testAddProduct() {
        cart.addProduct("Orange", 1.2, 4);
        Map<String, Integer> cartItems = cart.getCartInOrder();
        assertTrue(cartItems.containsKey("Orange"));
        assertEquals(4, cartItems.get("Orange"));
    }

    @Test
    void testRemoveProduct() {
        cart.removeProduct("Banana");
        assertFalse(cart.getCartInOrder().containsKey("Banana"));
    }

    @Test
    void testGetTotalPrice() {
        double expectedTotal = (3 * 1.5) + (5 * 0.8) + (2 * 2.0);
        assertEquals(expectedTotal, cart.getTotalPrice(), 0.01);
    }

    @Test
    void testGetCartInOrder() {
        Map<String, Integer> orderedCart = cart.getCartInOrder();
        assertEquals(3, orderedCart.get("Apple"));
        assertEquals(5, orderedCart.get("Banana"));
        assertEquals(2, orderedCart.get("Cherry"));
    }

    @Test
    void testGetProductsSortedByPrice() {
        Map<String, Double> sortedProducts = cart.getProductsSortedByPrice();

        // Ensure the products are sorted by price
        String firstProduct = sortedProducts.entrySet().iterator().next().getKey();
        assertEquals("Banana", firstProduct); // Banana should be first (price = 0.8)

        assertEquals(0.8, sortedProducts.get("Banana"));
        assertEquals(1.5, sortedProducts.get("Apple"));
        assertEquals(2.0, sortedProducts.get("Cherry"));
    }
}
