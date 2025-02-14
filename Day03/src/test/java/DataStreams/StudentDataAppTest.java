package DataStreams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataHandlerTest {
    private final String testFile = "test_students.dat";
    private StudentDataHandler handler;
    private List<Student> testStudents;

    @BeforeEach
    void setUp() {
        handler = new StudentDataHandler(testFile);
        testStudents = Arrays.asList(
                new Student(201, "David", 3.6),
                new Student(202, "Emma", 3.7)
        );
    }

    @Test
    void testStoreAndRetrieveStudents() throws IOException {
        // Store students
        handler.storeStudents(testStudents);

        // Retrieve and verify students
        List<Student> retrieved = handler.retrieveStudents();
        assertEquals(testStudents.size(), retrieved.size());

        for (int i = 0; i < testStudents.size(); i++) {
            assertEquals(testStudents.get(i).getRollNumber(), retrieved.get(i).getRollNumber());
            assertEquals(testStudents.get(i).getName(), retrieved.get(i).getName());
            assertEquals(testStudents.get(i).getGpa(), retrieved.get(i).getGpa());
        }

        // Cleanup
        Files.delete(Path.of(testFile));
    }
}
