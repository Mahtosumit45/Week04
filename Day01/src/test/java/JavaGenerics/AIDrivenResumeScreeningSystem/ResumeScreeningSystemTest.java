package JavaGenerics.AIDrivenResumeScreeningSystem;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ResumeScreeningSystemTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testSoftwareEngineerResume() {
        Resume<SoftwareEngineer> resume = new Resume<>(new SoftwareEngineer(), "Java, Spring Boot");
        assertTrue(resume.processResume());
    }

    @Test
    void testDataScientistResume() {
        Resume<DataScientist> resume = new Resume<>(new DataScientist(), "Machine Learning, Python");
        assertTrue(resume.processResume());
    }

    @Test
    void testProductManagerResume() {
        Resume<ProductManager> resume = new Resume<>(new ProductManager(), "Agile, Scrum");
        assertTrue(resume.processResume());
    }

    @Test
    void testInvalidSoftwareEngineerResume() {
        Resume<SoftwareEngineer> resume = new Resume<>(new SoftwareEngineer(), "Marketing, Sales");
        assertFalse(resume.processResume());
    }

    @Test
    void testInvalidDataScientistResume() {
        Resume<DataScientist> resume = new Resume<>(new DataScientist(), "Project Management");
        assertFalse(resume.processResume());
    }
}