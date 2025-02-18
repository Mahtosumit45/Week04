package Annotations_Java.Examples;

import java.util.ArrayList;

public class SuppressWarningsExample {

    @SuppressWarnings("unchecked") // Suppressing unchecked warnings
    public static void main(String[] args) {
        // Create an ArrayList without generics
        ArrayList list = new ArrayList();

        // Adding elements
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Accessing elements and printing
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

