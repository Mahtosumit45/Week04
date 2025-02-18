package Annotations_Java.Examples;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @BugReport annotation with a description field
@Retention(RetentionPolicy.RUNTIME)  // Make annotation available at runtime
@Target(ElementType.METHOD)  // Apply annotation to methods
@Repeatable(BugReports.class)  // Make this annotation repeatable
@interface BugReport {
    String description();  // A field to describe the bug
}

// Step 2: Define the container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();  // This holds the multiple @BugReport annotations
}

// Step 3: Create a class with a method that has multiple @BugReport annotations
class TaskManager2 {

    @BugReport(description = "Bug in login function.")
    @BugReport(description = "Error in user authentication process.")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

// Step 4: Retrieve and print all bug reports using reflection
public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> clazz = TaskManager2.class;

            // Get the method that has the @BugReport annotations
            Method method = clazz.getMethod("processTask");

            // Check if the method has the @BugReports container annotation
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);

                // Print all the bug report descriptions
                System.out.println("Bug Reports for method '" + method.getName() + "':");
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("- " + bugReport.description());
                }
            } else {
                System.out.println("No bug reports found.");
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

