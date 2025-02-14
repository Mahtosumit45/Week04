package Serialization;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSerializerTest {

    private final String testFilePath = "test_employees.ser";

    @Test
    void testSerializationAndDeserialization() throws IOException, ClassNotFoundException {
        EmployeeSerializer serializer = new EmployeeSerializer(testFilePath);
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 60000),
                new Employee(2, "Emma", "HR", 55000)
        );

        // Serialize
        serializer.serializeEmployees(employees);
        File file = new File(testFilePath);
        assertTrue(file.exists()); // Check if file is created

        // Deserialize
        List<Employee> deserializedEmployees = serializer.deserializeEmployees();
        assertNotNull(deserializedEmployees);
        assertEquals(2, deserializedEmployees.size());

        // Verify content
        assertEquals("John", deserializedEmployees.get(0).getName());
        assertEquals("Emma", deserializedEmployees.get(1).getName());

        // Cleanup
        file.delete();
    }
}
