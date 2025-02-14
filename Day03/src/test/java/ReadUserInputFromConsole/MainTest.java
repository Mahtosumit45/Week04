package ReadUserInputFromConsole;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UserInputHandlerTest {

    @Test
    void testWriteToFile() throws IOException {
        String filePath = "test_user_data.txt";
        UserDataWriter writer = new UserDataWriter(filePath);
        writer.writeToFile("Alice", 25, "Java");

        // Verify file contents
        File file = new File(filePath);
        assertTrue(file.exists());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            assertEquals("Name: Alice", br.readLine());
            assertEquals("Age: 25", br.readLine());
            assertEquals("Favorite Language: Java", br.readLine());
        }

        // Cleanup
        file.delete();
    }
}
