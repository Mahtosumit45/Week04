package Annotations_Java.Examples;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@Target(ElementType.METHOD) // Apply annotation to methods
@interface TaskInfo {
    String priority(); // Field to specify priority
    String assignedTo(); // Field to specify assigned person
}

// Step 2: Create a class TaskManager and apply the annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
}

// Step 3: Retrieve annotation details using Reflection
public class TaskInfoExample {
    public static void main(String[] args) {
        try {
            // Retrieve the TaskManager class
            Class<?> clazz = TaskManager.class;

            // Get the method annotated with @TaskInfo
            Method method = clazz.getMethod("completeTask");

            // Check if the method has the @TaskInfo annotation
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Get the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Print the annotation values
                System.out.println("Task Info:");
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned to: " + taskInfo.assignedTo());
            } else {
                System.out.println("No TaskInfo annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

