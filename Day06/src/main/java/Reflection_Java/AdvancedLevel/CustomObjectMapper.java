package Reflection_Java.AdvancedLevel;

import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    // Method to map values from Map to Object fields using Reflection
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through the entries of the map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                // Get the field corresponding to the map key
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    // Get the field in the class by name
                    Field field = clazz.getDeclaredField(fieldName);

                    // Make the field accessible if it's private
                    field.setAccessible(true);

                    // Set the field's value
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("No such field: " + fieldName);
                }
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Example usage
    public static void main(String[] args) {
        // Create a map with field names and their corresponding values
        Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 30
        );

        // Call the toObject method to populate an instance of Person class
        Person person = toObject(Person.class, properties);

        // Print the resulting object
        if (person != null) {
            System.out.println(person);
        }
    }
}

// A sample class with fields to demonstrate the custom object mapper
class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {}

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

