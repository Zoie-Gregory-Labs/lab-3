import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        System.out.println("Connecting to database...");

        ArrayList<Employee> employees = employeeDAO.getAllSalaries();

        System.out.println(employees.size());
    }
}
