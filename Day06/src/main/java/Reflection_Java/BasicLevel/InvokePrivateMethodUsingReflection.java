package Reflection_Java.BasicLevel;

import java.lang.reflect.Method;

class Calculator {
    // Private method to multiply two integers
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethodUsingReflection {
    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Access the private method 'multiply' using reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Set the method accessible since it's private
            multiplyMethod.setAccessible(true);

            // Invoke the private method on the calculator instance
            Object result = multiplyMethod.invoke(calculator, 5, 3); // Passing 5 and 3 as arguments

            // Display the result of the method invocation
            System.out.println("Multiplication result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

