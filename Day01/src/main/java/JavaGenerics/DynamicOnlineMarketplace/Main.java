package JavaGenerics.DynamicOnlineMarketplace;

// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory() {});
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 30.0, new ClothingCategory() {});
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, new GadgetCategory() {});

        System.out.println("Before Discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 15);

        System.out.println("\nAfter Discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
