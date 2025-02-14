package BufferedStreams;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileCopyUtilityTest {

    @Test
    void testCopyFileWithBuffer() throws IOException {
        String sourceFile = "test_source.txt";
        String destinationFile = "test_dest_buffered.txt";

        // Create a test file
        File file = new File(sourceFile);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write("This is a test file.".getBytes());
            }
        }

        // Copy file using buffered method
        FileCopyUtility.copyFileWithBuffer(sourceFile, destinationFile);

        // Check if destination file exists and has same content
        File copiedFile = new File(destinationFile);
        assertTrue(copiedFile.exists());
        assertEquals(file.length(), copiedFile.length());

        // Cleanup
        file.delete();
        copiedFile.delete();
    }

    @Test
    void testCopyFileWithoutBuffer() throws IOException {
        String sourceFile = "test_source.txt";
        String destinationFile = "test_dest_unbuffered.txt";

        // Create a test file
        File file = new File(sourceFile);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write("Testing unbuffered copy.".getBytes());
            }
        }

        // Copy file using unbuffered method
        FileCopyUtility.copyFileWithoutBuffer(sourceFile, destinationFile);

        // Check if destination file exists and has same content
        File copiedFile = new File(destinationFile);
        assertTrue(copiedFile.exists());
        assertEquals(file.length(), copiedFile.length());

        // Cleanup
        file.delete();
        copiedFile.delete();
    }
}
