package Serialization;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "employees.ser";
        EmployeeSerializer serializer = new EmployeeSerializer(filePath);

        // Creating Employee List
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", "HR", 50000),
                new Employee(102, "Bob", "IT", 70000),
                new Employee(103, "Charlie", "Finance", 60000)
        );

        try {
            // Serialize employees
            serializer.serializeEmployees(employees);
            System.out.println("Employees serialized successfully!");

            // Deserialize employees
            List<Employee> retrievedEmployees = serializer.deserializeEmployees();
            System.out.println("Deserialized Employees:");
            retrievedEmployees.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

