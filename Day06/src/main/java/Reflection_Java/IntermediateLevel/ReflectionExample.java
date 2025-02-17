package Reflection_Java.IntermediateLevel;

import java.lang.reflect.Field;

public class ReflectionExample {

    // Configuration class with a private static field API_KEY
    public static class Configuration {
        private static String API_KEY = "OldAPIKey123"; // Initial value of API_KEY
    }

    public static void main(String[] args) {
        try {
            // Get the Configuration class object
            Class<?> configClass = Configuration.class;

            // Access the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the private field accessible
            apiKeyField.setAccessible(true);

            // Print the current value of the API_KEY before modification
            System.out.println("Before modification: " + apiKeyField.get(null));

            // Modify the static field API_KEY to a new value
            apiKeyField.set(null, "NewAPIKey456");

            // Print the modified value of the API_KEY after modification
            System.out.println("After modification: " + apiKeyField.get(null));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

