package FileHandling;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String sourcePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/hi.txt";  // Provide an existing file path
        String destinationPath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/hello.txt";

        if (fileHandler.copyFile(sourcePath, destinationPath)) {
            System.out.println("File copied successfully!");
        } else {
            System.out.println("Failed to copy the file.");
        }
    }
}

