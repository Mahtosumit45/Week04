package Reflection_Java.IntermediateLevel;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {

    // MathOperations class with multiple methods
    public static class MathOperations {

        // Method to add two numbers
        public int add(int a, int b) {
            return a + b;
        }

        // Method to subtract two numbers
        public int subtract(int a, int b) {
            return a - b;
        }

        // Method to multiply two numbers
        public int multiply(int a, int b) {
            return a * b;
        }
    }

    public static void main(String[] args) {
        try {
            // Scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Ask the user to enter the operation they want to perform
            System.out.println("Enter operation (add, subtract, multiply): ");
            String operation = scanner.nextLine().toLowerCase();

            // Ask the user to enter two numbers for the operation
            System.out.println("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.println("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Get the Method object corresponding to the user input (operation)
            Method method = MathOperations.class.getMethod(operation, int.class, int.class);

            // Dynamically invoke the method on the mathOperations object
            Object result = method.invoke(mathOperations, num1, num2);

            // Print the result of the operation
            System.out.println("Result of " + operation + ": " + result);

            // Close the scanner
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

