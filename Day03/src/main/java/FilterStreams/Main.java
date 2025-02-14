package FilterStreams;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/hello.txt";   // Provide an existing text file
        String outputFile = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/hi.txt";

        try {
            // Convert Uppercase to Lowercase
            TextConverter.convertToLowercase(inputFile, outputFile);
            System.out.println("Conversion completed successfully!");

            // Display content for verification
            System.out.println("Converted Content:\n" + TextConverter.readFileContent(outputFile));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

