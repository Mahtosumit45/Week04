package JavaGenerics.warehouseManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Storage for Electronics
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.add(new Electronics("Laptop"));
        electronicsStorage.add(new Electronics("Smartphone"));
        electronicsStorage.add(new Electronics("Tablet"));


        // Storage for Groceries
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.add(new Groceries("Apples"));
        groceriesStorage.add(new Groceries("Milk"));
        groceriesStorage.add(new Groceries("Bread"));


        // Storage for Furniture
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.add(new Furniture("Chair"));
        furnitureStorage.add(new Furniture("Table"));
        furnitureStorage.add(new Furniture("Sofa"));


        //Demonstrating Wildcard
        System.out.println("\nUsing Wildcard:");
        WildCard.wildCard(electronicsStorage.getList());
        WildCard.wildCard(groceriesStorage.getList());
        WildCard.wildCard(furnitureStorage.getList());


        //Example of getting an item by index
        Electronics laptop = electronicsStorage.get(0);
        if(laptop != null) {
            System.out.println("\nItem at index 0 in electronics storage: " + laptop.getItemName());
        }

        Groceries milk = groceriesStorage.get(1);
        if(milk != null) {
            System.out.println("Item at index 1 in groceries storage: " + milk.getItemName());
        }


    }
}