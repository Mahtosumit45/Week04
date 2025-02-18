package Annotations_Java.IntermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)  // Make annotation available at runtime
@Target(ElementType.METHOD)  // Can only be applied to methods
@interface LogExecutionTime {
    // This annotation does not need any fields
}

// Step 2: Create a class with methods that will use the @LogExecutionTime annotation
class TaskManager {

    @LogExecutionTime  // Mark method to log execution time
    public void processLargeTask() {
        try {
            // Simulate time-consuming task
            Thread.sleep(500);  // Simulating a delay of 500 ms
            System.out.println("Processing large task...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime  // Mark method to log execution time
    public void processSmallTask() {
        try {
            // Simulate time-consuming task
            Thread.sleep(200);  // Simulating a delay of 200 ms
            System.out.println("Processing small task...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Use reflection to calculate the execution time of methods with @LogExecutionTime
public class ExecutionTimeAnnotations {
    public static void main(String[] args) {
        try {
            TaskManager taskManager = new TaskManager();

            // Get the TaskManager class
            Class<?> clazz = taskManager.getClass();

            // Get all methods in the class
            Method[] methods = clazz.getDeclaredMethods();

            // Iterate through the methods and check for @LogExecutionTime annotations
            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    // Capture start time
                    long startTime = System.nanoTime();

                    // Invoke the method using reflection
                    method.invoke(taskManager);

                    // Capture end time
                    long endTime = System.nanoTime();

                    // Calculate the time taken in nanoseconds
                    long duration = endTime - startTime;

                    // Print the execution time
                    System.out.println("Execution time of method '" + method.getName() + "': " + duration + " nanoseconds");
                    System.out.println("--------------------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

