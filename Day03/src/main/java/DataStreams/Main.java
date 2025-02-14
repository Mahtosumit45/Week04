package DataStreams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "students.dat";
        StudentDataHandler handler = new StudentDataHandler(filePath);

        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", 3.8));
        students.add(new Student(102, "Bob", 3.5));
        students.add(new Student(103, "Charlie", 3.9));

        try {
            // Store student data
            handler.storeStudents(students);
            System.out.println("Student data stored successfully!");

            // Retrieve and display student data
            List<Student> retrievedStudents = handler.retrieveStudents();
            System.out.println("Retrieved Student Data:");
            retrievedStudents.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

