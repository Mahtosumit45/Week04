package DataStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataHandler {
    private final String filePath;

    public StudentDataHandler(String filePath) {
        this.filePath = filePath;
    }

    // Store students in a binary file
    public void storeStudents(List<Student> students) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(students.size()); // Write number of students
            for (Student student : students) {
                dos.writeInt(student.getRollNumber());
                dos.writeUTF(student.getName());
                dos.writeDouble(student.getGpa());
            }
        }
    }

    // Retrieve students from a binary file
    public List<Student> retrieveStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int size = dis.readInt(); // Read the number of students
            for (int i = 0; i < size; i++) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                students.add(new Student(rollNumber, name, gpa));
            }
        }
        return students;
    }
}

