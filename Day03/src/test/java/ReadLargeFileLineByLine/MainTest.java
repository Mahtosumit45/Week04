package ReadLargeFileLineByLine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LargeFileReaderTest {
    private static final String TEST_FILE_PATH = "test_file.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Creating a test file with sample data
        File testFile = new File(TEST_FILE_PATH);
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("This is a normal line.\n");
            writer.write("An ERROR occurred in the system.\n");
            writer.write("Another normal line.\n");
            writer.write("Critical ERROR detected!\n");
        }
    }

    @Test
    void testReadLinesContainingError() {
        LargeFileReader fileReader = new LargeFileReader(TEST_FILE_PATH);
        List<String> errorLines = fileReader.readLinesContainingError();

        assertEquals(2, errorLines.size());
        assertTrue(errorLines.get(0).contains("ERROR"));
        assertTrue(errorLines.get(1).contains("ERROR"));
    }
}
