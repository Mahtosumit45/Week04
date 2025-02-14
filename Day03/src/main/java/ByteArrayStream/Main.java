package ByteArrayStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputImagePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/Input.jpg";  // Provide an existing image path
        String outputImagePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = ImageConverter.imageToByteArray(inputImagePath);
            System.out.println("Image converted to byte array successfully!");

            // Convert byte array back to image
            ImageConverter.byteArrayToImage(imageBytes, outputImagePath);
            System.out.println("Byte array converted back to image successfully!");

            // Verify if both images are identical
            boolean isIdentical = ImageConverter.compareImages(inputImagePath, outputImagePath);
            System.out.println("Images are identical: " + isIdentical);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

