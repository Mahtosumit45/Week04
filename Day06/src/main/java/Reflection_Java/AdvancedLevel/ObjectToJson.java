package Reflection_Java.AdvancedLevel;

import java.lang.reflect.Field;

public class ObjectToJson {

    // Method to convert an object to a JSON-like string using Reflection
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();

        // Start the JSON object
        jsonBuilder.append("{");

        // Get all fields of the object's class (including private fields)
        Field[] fields = obj.getClass().getDeclaredFields();

        boolean firstField = true;

        // Iterate through the fields of the object
        for (Field field : fields) {
            try {
                // Make the field accessible if it's private
                field.setAccessible(true);

                // Get the field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                // Add a comma if it's not the first field
                if (!firstField) {
                    jsonBuilder.append(", ");
                }
                firstField = false;

                // Add the field name and value to the JSON string
                jsonBuilder.append("\"").append(fieldName).append("\": ");

                // Check if the field value is a string, and add quotes accordingly
                if (fieldValue instanceof String) {
                    jsonBuilder.append("\"").append(fieldValue).append("\"");
                } else {
                    jsonBuilder.append(fieldValue);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // End the JSON object
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

    // Example usage
    public static void main(String[] args) {
        // Create an example object
        Person person = new Person("John Doe", 30);

        // Convert the person object to a JSON-like string
        String jsonString = toJson(person);

        // Print the JSON string
        System.out.println(jsonString);
    }

    // A sample class to demonstrate the conversion
    public static class Person {
        private String name;
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

