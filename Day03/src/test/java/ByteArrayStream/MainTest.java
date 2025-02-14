package ByteArrayStream;
import java.io.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ImageConverterTest {

    private final String inputImagePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/Input.jpg"; // Provide an actual test image
    private final String outputImagePath = "/Users/sumitkumarmahto/Desktop/Week04/Day03/src/main/resources/output.jpg";

    @Test
    void testImageToByteArray() throws IOException {
        byte[] imageBytes = ImageConverter.imageToByteArray(inputImagePath);
        assertNotNull(imageBytes);
        assertTrue(imageBytes.length > 0);
    }

    @Test
    void testByteArrayToImage() throws IOException {
        byte[] imageBytes = ImageConverter.imageToByteArray(inputImagePath);
        ImageConverter.byteArrayToImage(imageBytes, outputImagePath);

        // Verify output file exists
        assertTrue(new java.io.File(outputImagePath).exists());
    }

    @Test
    void testCompareImages() throws IOException {
        byte[] imageBytes = ImageConverter.imageToByteArray(inputImagePath);
        ImageConverter.byteArrayToImage(imageBytes, outputImagePath);

        // Verify the images are identical
        assertTrue(ImageConverter.compareImages(inputImagePath, outputImagePath));
    }
}
