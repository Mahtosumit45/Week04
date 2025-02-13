package MapInterface.GroupObjectProperty;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeGrouperTest {

    @Test
    void testGroupByDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.IT),
                new Employee("Eve", Department.FINANCE)
        );

        Map<Department, List<Employee>> result = EmployeeGrouper.groupByDepartment(employees);

        assertEquals(2, result.get(Department.HR).size());
        assertEquals(2, result.get(Department.IT).size());
        assertEquals(1, result.get(Department.FINANCE).size());
        assertFalse(result.get(Department.HR).contains(new Employee("Alice", Department.HR)));
    }

    @Test
    void testEmptyList() {
        List<Employee> employees = new ArrayList<>();
        Map<Department, List<Employee>> result = EmployeeGrouper.groupByDepartment(employees);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.MARKETING),
                new Employee("Bob", Department.MARKETING)
        );

        Map<Department, List<Employee>> result = EmployeeGrouper.groupByDepartment(employees);
        assertEquals(1, result.size());
        assertEquals(2, result.get(Department.MARKETING).size());
    }

    @Test
    void testUniqueDepartments() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.FINANCE)
        );

        Map<Department, List<Employee>> result = EmployeeGrouper.groupByDepartment(employees);
        assertEquals(3, result.size());
        assertEquals(1, result.get(Department.HR).size());
        assertEquals(1, result.get(Department.IT).size());
        assertEquals(1, result.get(Department.FINANCE).size());
    }
}
