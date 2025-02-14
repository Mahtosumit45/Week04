package ByteArrayStream;

import java.io.*;

public class ImageConverter {

    // Convert Image to Byte Array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Convert Byte Array back to Image
    public static void byteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Verify if two image files are identical
    public static boolean compareImages(String filePath1, String filePath2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(filePath1);
             FileInputStream fis2 = new FileInputStream(filePath2)) {
            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
                if (byte1 != byte2) return false;
            }
            return fis1.read() == fis2.read(); // Ensure both files end at the same time
        }
    }
}

