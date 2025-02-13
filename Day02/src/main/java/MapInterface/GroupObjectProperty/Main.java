package MapInterface.GroupObjectProperty;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.IT),
                new Employee("Eve", Department.FINANCE)
        );

        Map<Department, List<Employee>> grouped = EmployeeGrouper.groupByDepartment(employees);

        for (Map.Entry<Department, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

