package Serialization;

import java.io.*;
import java.util.List;

public class EmployeeSerializer {
    private String filePath;

    public EmployeeSerializer(String filePath) {
        this.filePath = filePath;
    }

    // Serialize Employee List
    public void serializeEmployees(List<Employee> employees) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
        }
    }

    // Deserialize Employee List
    public List<Employee> deserializeEmployees() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Employee>) ois.readObject();
        }
    }
}

