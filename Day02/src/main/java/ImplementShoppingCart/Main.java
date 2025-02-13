package ImplementShoppingCart;
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Apple", 1.5, 3);
        cart.addProduct("Banana", 0.8, 5);
        cart.addProduct("Cherry", 2.0, 2);

        System.out.println("\nCart (Order Added): " + cart.getCartInOrder());
        System.out.println("\nProducts Sorted by Price: " + cart.getProductsSortedByPrice());
        System.out.println("\nTotal Price: $" + cart.getTotalPrice());

        // Removing a product
        cart.removeProduct("Banana");
        System.out.println("\nCart after removing Banana: " + cart.getCartInOrder());
    }
}

