package Reflection_Java.BasicLevel;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfoRetriever {
    public static void main(String[] args) {
        // Accept class name from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Get Class object for the given class name
            Class<?> cls = Class.forName(className);

            // Display class information
            System.out.println("Class Name: " + cls.getName());

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}

