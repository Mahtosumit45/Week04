package ImplementShoppingCart;
import java.util.*;

public class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price, int quantity) {
        priceMap.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(String product) {
        cart.remove(product);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += priceMap.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public Map<String, Integer> getCartInOrder() {
        return new LinkedHashMap<>(cart);
    }

    public Map<String, Double> getProductsSortedByPrice() {
        TreeMap<String, Double> sortedMap = new TreeMap<>(Comparator.comparing(priceMap::get));
        sortedMap.putAll(priceMap);
        return sortedMap;
    }

}

