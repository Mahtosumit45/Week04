package Annotations_Java.IntermediateLevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.FIELD)  // The annotation is used for fields
@interface MaxLength {
    int value();  // Specifies the maximum length for the string field
}

// Step 2: Create a User class with a username field annotated with @MaxLength
class User {

    @MaxLength(10)  // Apply the annotation to the username field with a max length of 10
    private String username;

    // Constructor that validates the length of the username
    public User(String username) {
        // Check if the username field has the @MaxLength annotation
        try {
            Field usernameField = this.getClass().getDeclaredField("username");
            MaxLength annotation = usernameField.getAnnotation(MaxLength.class);

            if (annotation != null) {
                int maxLength = annotation.value();

                // Validate the length of the username
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username length exceeds the maximum allowed length of " + maxLength);
                }
            }

            // If validation passes, set the username
            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

// Step 3: Test the User class
public class MaxLengthAnnotations {
    public static void main(String[] args) {
        try {
            // Test with a valid username
            User user1 = new User("JohnDoe");
            System.out.println("User created: " + user1.getUsername());

            // Test with an invalid username (exceeds the max length of 10)
            User user2 = new User("VeryLongUsername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

