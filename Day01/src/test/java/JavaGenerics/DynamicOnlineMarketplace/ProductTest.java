package JavaGenerics.DynamicOnlineMarketplace;
// JUnit Test Class
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product<BookCategory> book;
    private Product<ClothingCategory> shirt;
    private Product<GadgetCategory> phone;

    @BeforeEach
    void setUp() {
        book = new Product<>("Java Programming", 50.0, new BookCategory() {});
        shirt = new Product<>("Casual Shirt", 30.0, new ClothingCategory() {});
        phone = new Product<>("Smartphone", 500.0, new GadgetCategory() {});
    }

    @Test
    void testApplyDiscount() {
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 15);

        assertEquals(45.0, book.getPrice());
        assertEquals(24.0, shirt.getPrice());
        assertEquals(425.0, phone.getPrice());
    }

    @Test
    void testNoDiscount() {
        assertEquals(50.0, book.getPrice());
        assertEquals(30.0, shirt.getPrice());
        assertEquals(500.0, phone.getPrice());
    }

    @Test
    void testHighDiscount() {
        DiscountUtil.applyDiscount(book, 100);
        assertEquals(0.0, book.getPrice());
    }

    @Test
    void testNegativeDiscount() {
        DiscountUtil.applyDiscount(book, -10);
        assertEquals(55.0, book.getPrice()); // Price increases by 10%
    }
}
