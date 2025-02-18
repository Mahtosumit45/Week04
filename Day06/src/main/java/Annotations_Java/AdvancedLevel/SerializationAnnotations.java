package Annotations_Java.AdvancedLevel;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)  // Make annotation available at runtime
@Target(ElementType.FIELD)  // The annotation is used for fields
@interface JsonField {
    String name();  // Custom JSON key name for the field
}

// Step 2: Create a User class with fields annotated with @JsonField
class User2 {
    @JsonField(name = "user_name")  // Custom JSON key for this field
    private String username;

    @JsonField(name = "user_age")  // Custom JSON key for this field
    private int age;

    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}

// Step 3: Create a method to convert an object to JSON string using the annotations
public class SerializationAnnotations {

    public static String toJson(Object obj) {
        Map<String, String> jsonMap = new HashMap<>();

        // Step 3a: Use reflection to get all fields of the object
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        // Step 3b: Iterate through each field and check if it's annotated with @JsonField
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                // Get the @JsonField annotation
                JsonField jsonField = field.getAnnotation(JsonField.class);

                // Set the field accessible (in case it's private)
                field.setAccessible(true);

                try {
                    // Get the value of the field from the object
                    Object value = field.get(obj);

                    // Get the custom name for the field from the annotation
                    String customJsonKey = jsonField.name();

                    // Add the field name and its value to the JSON map
                    jsonMap.put(customJsonKey, value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Step 3c: Convert the JSON map to a JSON string (simple representation)
        StringBuilder jsonString = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            jsonString.append("\"")
                    .append(entry.getKey())
                    .append("\": \"")
                    .append(entry.getValue())
                    .append("\", ");
        }

        // Remove the trailing comma and space, if present
        if (!jsonMap.isEmpty()) {
            jsonString.setLength(jsonString.length() - 2);
        }

        jsonString.append("}");

        return jsonString.toString();
    }

    public static void main(String[] args) {
        // Create a User object
        User2 user = new User2("Alice", 30);

        // Convert the User object to JSON
        String json = toJson(user);
        System.out.println(json);  // Output should be: {"user_name": "Alice", "user_age": "30"}
    }
}

