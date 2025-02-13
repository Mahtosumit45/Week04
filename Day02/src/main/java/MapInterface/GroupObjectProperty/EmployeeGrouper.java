package MapInterface.GroupObjectProperty;
import java.util.*;

public class EmployeeGrouper {

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> groupedEmployees = new HashMap<>();

        for (Employee emp : employees) {
            groupedEmployees.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }

        return groupedEmployees;
    }
}

