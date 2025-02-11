package JavaGenerics.AIDrivenResumeScreeningSystem;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer(), "Java, Spring Boot");
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist(), "Machine Learning, Python");
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager(), "Agile, Roadmap Planning");

        System.out.println("Software Engineer Resume Passed: " + seResume.processResume());
        System.out.println("Data Scientist Resume Passed: " + dsResume.processResume());
        System.out.println("Product Manager Resume Passed: " + pmResume.processResume());
    }
}

