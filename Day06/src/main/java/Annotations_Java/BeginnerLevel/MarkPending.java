package Annotations_Java.BeginnerLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation with task, assignedTo, and priority fields
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // The annotation can only be applied to methods
@interface Todo {
    String task();  // Description of the task
    String assignedTo();  // Developer responsible
    String priority() default "MEDIUM";  // Default priority is "MEDIUM"
}

// Step 2: Define a new class TaskManager2 with methods annotated with @Todo
class TaskManager2 {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void implementLogin() {
        System.out.println("Login feature implementation is in progress.");
    }

    @Todo(task = "Fix UI bug in dashboard", assignedTo = "Bob", priority = "LOW")
    public void fixUIDashboardBug() {
        System.out.println("Fixing UI bug in dashboard.");
    }

    @Todo(task = "Add user profile page", assignedTo = "Charlie")  // Default priority is "MEDIUM"
    public void addUserProfilePage() {
        System.out.println("User profile page is being added.");
    }
}

// Step 3: Retrieve and print all methods annotated with @Todo using Reflection
public class MarkPending {
    public static void main(String[] args) {
        try {
            // Get the TaskManager2 class
            Class<?> clazz = TaskManager2.class;

            // Get all methods in the class
            Method[] methods = clazz.getDeclaredMethods();

            // Iterate through the methods and check for @Todo annotations
            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    // Get the @Todo annotation
                    Todo todo = method.getAnnotation(Todo.class);

                    // Print task details
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println("Method: " + method.getName());
                    System.out.println("--------------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

