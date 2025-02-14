package FileHandling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FileHandlerTest {
    private FileHandler fileHandler;
    private final String sourceFile = "test_source.txt";
    private final String destinationFile = "test_destination.txt";

    @BeforeEach
    void setUp() throws IOException {
        fileHandler = new FileHandler();

        // Create a test file with some content
        File file = new File(sourceFile);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, this is a test file!");
        }
    }

    @Test
    void testCopyFile_Success() {
        assertTrue(fileHandler.copyFile(sourceFile, destinationFile), "File should be copied successfully");

        // Verify destination file exists
        File destFile = new File(destinationFile);
        assertTrue(destFile.exists(), "Destination file should be created");
    }

    @Test
    void testCopyFile_SourceNotExists() {
        assertFalse(fileHandler.copyFile("non_existent.txt", destinationFile), "Copy should fail for a non-existent file");
    }

    @Test
    void testCopyFile_ContentCheck() throws IOException {
        fileHandler.copyFile(sourceFile, destinationFile);

        // Read destination file content
        File destFile = new File(destinationFile);
        assertTrue(destFile.exists(), "Destination file should exist");

        // Verify content matches
        String content = new String(java.nio.file.Files.readAllBytes(destFile.toPath()));
        assertEquals("Hello, this is a test file!", content.trim(), "File content should match");
    }
}
