package Annotations_Java.Examples;

// Step 1: Define the LegacyAPI class
class LegacyAPI {

    // Step 2: Mark oldFeature() as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It should not be used anymore.");
    }

    // Step 3: Define a new method newFeature()
    public void newFeature() {
        System.out.println("This is the new feature. Use this instead of oldFeature.");
    }
}

// Step 4: Main class to call the methods
public class LegacyAPIExapmle {
    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();

        // Call the deprecated oldFeature() method
        legacyAPI.oldFeature();  // This will trigger a compilation warning

        // Call the newFeature() method
        legacyAPI.newFeature();  // This is the preferred method
    }
}

