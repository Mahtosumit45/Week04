package FilterStreams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TextConverterTest {

    private final String testInputFile = "test_input.txt";
    private final String testOutputFile = "test_output.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create test input file with uppercase content
        Files.write(Path.of(testInputFile), "HELLO WORLD\nJAVA TESTING".getBytes());
    }

    @Test
    void testConvertToLowercase() throws IOException {
        // Perform conversion
        TextConverter.convertToLowercase(testInputFile, testOutputFile);

        // Verify output content
        String expectedContent = "hello world\njava testing";
        String actualContent = TextConverter.readFileContent(testOutputFile);

        assertEquals(expectedContent, actualContent);
    }
}
