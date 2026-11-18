import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    // Four tests for printSalaries()

    @Test
    void printSalariesTestNull() {
        App.printSalaries(null);
    }

    @Test
    void printSalariesTestEmpty() {
        ArrayList<Employee> employees = new ArrayList<>();
        App.printSalaries(employees);
    }

    @Test
    void printSalariesTestContainsNull() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(null);
        App.printSalaries(employees);
    }

    @Test
    void printSalariesTestNormal() {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee emp = new Employee(1, "Kevin", "Chalmers", 55000);
        employees.add(emp);
        App.printSalaries(employees);
    }

    // Helper method to capture displayed employee details
    private String captureDisplay(Employee employee) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;

        try {
            System.setOut(new PrintStream(output));
            employee.displayEmployee();
        } finally {
            System.setOut(original);
        }

        return output.toString();
    }

    // Test normal employee details
    @Test
    void displayEmployeeTestNormal() {
        Department dept = new Department();
        dept.dept_no = "d001";
        dept.dept_name = "Engineering";

        Employee manager =
                new Employee(10, "Alice", "Manager", 70000);

        Employee employee = new Employee(
                1, "Kevin", "Chalmers",
                "Engineer", 55000, dept, manager
        );

        String result = captureDisplay(employee);

        assertTrue(result.contains("Employee Number: 1"));
        assertTrue(result.contains("First Name: Kevin"));
        assertTrue(result.contains("Last Name: Chalmers"));
        assertTrue(result.contains("Job Title: Engineer"));
        assertTrue(result.contains("Salary: 55000"));
        assertTrue(result.contains("Department: "));
        assertTrue(result.contains("Manager: "));
    }

    // Test employee with null optional details
    @Test
    void displayEmployeeTestNullDetails() {
        Employee employee =
                new Employee(2, "John", "Smith", 40000);

        String result = captureDisplay(employee);

        assertTrue(result.contains("Job Title: null"));
        assertTrue(result.contains("Department: null"));
        assertTrue(result.contains("Manager: null"));
    }
}