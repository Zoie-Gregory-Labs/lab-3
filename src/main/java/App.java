import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("HR Management System");
        System.out.print("Enter Employee Number: ");

        int employeeID = scanner.nextInt();

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee = employeeDAO.getEmployee(employeeID);

        if (employee != null) {
            System.out.println("\nEmployee Details");
            employee.displayEmployee();
        } else {
            System.out.println("Employee not found.");
        }

        scanner.close();
    }
}
