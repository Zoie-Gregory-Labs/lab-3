
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println("HR Management System");
        System.out.println("1. View Employee Details");
        System.out.println("2. View All Employee Salaries");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Enter Employee Number: ");
            int employeeID = scanner.nextInt();

            Employee employee = employeeDAO.getEmployee(employeeID);

            if (employee != null) {
                System.out.println("\nEmployee Details");
                employee.displayEmployee();
            } else {
                System.out.println("Employee not found.");
            }

        } else if (choice == 2) {

            ArrayList<Employee> employees = employeeDAO.getAllSalaries();

            if (employees != null && !employees.isEmpty()) {
                printSalaries(employees);
            } else {
                System.out.println("No salary records found.");
            }

        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    public static void printSalaries(ArrayList<Employee> employees) {

        System.out.println("\nCurrent Employee Salaries");

        System.out.println(String.format("%-10s %-15s %-20s %-10s",
                "Emp No", "First Name", "Last Name", "Salary"));

        for (Employee emp : employees) {

            String empString = String.format("%-10s %-15s %-20s %-10s",
                    emp.getEmpNo(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getSalary());

            System.out.println(empString);
        }
    }
}
