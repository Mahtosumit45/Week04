package BufferedStreams;

import java.io.*;

public class FileCopyUtility {
    private static final int BUFFER_SIZE = 4096; // 4KB buffer size

    // Method to copy file using Buffered Streams
    public static void copyFileWithBuffer(String source, String destination) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to copy file using Unbuffered Streams
    public static void copyFileWithoutBuffer(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        }
    }
}

