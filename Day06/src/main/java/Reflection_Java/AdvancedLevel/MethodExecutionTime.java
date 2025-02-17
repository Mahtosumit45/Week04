package Reflection_Java.AdvancedLevel;

import java.lang.reflect.Method;

public class MethodExecutionTime {

    // Example class to be tested
    public static class SampleClass {
        public void methodOne() {
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void methodTwo() {
            try {
                Thread.sleep(200); // Simulate more work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to measure execution time dynamically using reflection
    public static void measureExecutionTime(Object object, String methodName) {
        try {
            // Get the method by name
            Method method = object.getClass().getMethod(methodName);

            // Record start time
            long startTime = System.nanoTime();

            // Invoke the method
            method.invoke(object);

            // Record end time
            long endTime = System.nanoTime();

            // Calculate elapsed time
            long duration = endTime - startTime;
            System.out.println("Method '" + methodName + "' executed in " + duration + " nanoseconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SampleClass sample = new SampleClass();

        // Measure the execution time of methodOne
        measureExecutionTime(sample, "methodOne");

        // Measure the execution time of methodTwo
        measureExecutionTime(sample, "methodTwo");
    }
}

