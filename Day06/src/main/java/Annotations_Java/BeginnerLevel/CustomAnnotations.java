package Annotations_Java.BeginnerLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @ImportantMethod annotation with an optional level parameter
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // The annotation can be applied to methods
@interface ImportantMethod {
    String level() default "HIGH";  // Optional parameter with default value "HIGH"
}

// Step 2: Define a class with methods that use the @ImportantMethod annotation
class TaskManager {

    @ImportantMethod(level = "HIGH")  // Apply @ImportantMethod with level HIGH
    public void urgentTask() {
        System.out.println("Urgent task is being processed.");
    }

    @ImportantMethod(level = "MEDIUM")  // Apply @ImportantMethod with level MEDIUM
    public void regularTask() {
        System.out.println("Regular task is being processed.");
    }

    @ImportantMethod()  // Apply @ImportantMethod with default level HIGH
    public void lowPriorityTask() {
        System.out.println("Low priority task is being processed.");
    }
}

// Step 3: Retrieve and print all methods annotated with @ImportantMethod using Reflection
public class CustomAnnotations {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> clazz = TaskManager.class;

            // Get all methods in the class
            Method[] methods = clazz.getDeclaredMethods();

            // Iterate through the methods and check for @ImportantMethod annotations
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    // Get the @ImportantMethod annotation
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);

                    // Print method name and the level of importance
                    System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

