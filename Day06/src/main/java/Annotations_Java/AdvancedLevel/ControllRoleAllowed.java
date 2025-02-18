package Annotations_Java.AdvancedLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)  // Make annotation available at runtime
@Target(ElementType.METHOD)  // Can only be applied to methods
@interface RoleAllowed {
    String value();  // Role required to access the method (e.g., "ADMIN")
}

// Step 2: Simulate a User class with roles
class User {
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Step 3: Define the TaskManager class with methods that require role-based access
class TaskManager {

    @RoleAllowed("ADMIN")  // Only ADMIN users can access this method
    public void performAdminTask() {
        System.out.println("Admin task is being performed.");
    }

    @RoleAllowed("USER")  // Only USERs can access this method
    public void performUserTask() {
        System.out.println("User task is being performed.");
    }
}

// Step 4: Create a class to check and simulate role-based access control
public class ControllRoleAllowed {
    public static void main(String[] args) {
        // Simulating users with different roles
        User adminUser = new User("Alice", "ADMIN");
        User normalUser = new User("Bob", "USER");

        // Simulating TaskManager with role-based access
        TaskManager taskManager = new TaskManager();

        // Test with admin user
        System.out.println("Admin trying to perform admin task:");
        checkAccessAndInvoke(adminUser, taskManager, "performAdminTask");

        System.out.println("\nAdmin trying to perform user task:");
        checkAccessAndInvoke(adminUser, taskManager, "performUserTask");

        // Test with normal user
        System.out.println("\nNormal user trying to perform admin task:");
        checkAccessAndInvoke(normalUser, taskManager, "performAdminTask");

        System.out.println("\nNormal user trying to perform user task:");
        checkAccessAndInvoke(normalUser, taskManager, "performUserTask");
    }

    // Step 5: Check if the user has the required role to access the method
    private static void checkAccessAndInvoke(User user, TaskManager taskManager, String methodName) {
        try {
            // Get the method from TaskManager class
            Method method = taskManager.getClass().getDeclaredMethod(methodName);

            // Check if the method is annotated with @RoleAllowed
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                // Get the required role from the annotation
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                // Check if the user's role matches the required role
                if (user.getRole().equals(requiredRole)) {
                    // User has the required role, invoke the method
                    method.invoke(taskManager);
                } else {
                    // User does not have the required role, access denied
                    System.out.println("Access Denied!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

