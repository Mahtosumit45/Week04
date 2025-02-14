package ReadUserInputFromConsole;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();
        UserDataWriter dataWriter = new UserDataWriter("user_data.txt");

        try {
            String name = inputHandler.readInput("Enter your name: ");
            int age = Integer.parseInt(inputHandler.readInput("Enter your age: "));
            String language = inputHandler.readInput("Enter your favorite programming language: ");

            dataWriter.writeToFile(name, age, language);
            System.out.println("User data saved successfully in user_data.txt!");

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid age input. Please enter a valid number.");
        }
    }
}

