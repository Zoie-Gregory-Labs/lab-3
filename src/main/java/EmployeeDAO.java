
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

    // Lab 3: Retrieve one employee by employee number
    public Employee getEmployee(int ID) {

        String sql = "SELECT e.emp_no, e.first_name, e.last_name, " +
                     "t.title, s.salary, d.dept_name, " +
                     "CONCAT(m.first_name, ' ', m.last_name) AS manager_name " +
                     "FROM employees e " +
                     "JOIN titles t ON e.emp_no = t.emp_no " +
                     "JOIN salaries s ON e.emp_no = s.emp_no " +
                     "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                     "JOIN departments d ON de.dept_no = d.dept_no " +
                     "LEFT JOIN dept_manager dm ON d.dept_no = dm.dept_no " +
                     "AND dm.to_date = '9999-01-01' " +
                     "LEFT JOIN employees m ON dm.emp_no = m.emp_no " +
                     "WHERE e.emp_no = ? " +
                     "AND t.to_date = '9999-01-01' " +
                     "AND s.to_date = '9999-01-01' " +
                     "AND de.to_date = '9999-01-01'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ID);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    return new Employee(
                        result.getInt("emp_no"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("title"),
                        result.getInt("salary"),
                        result.getString("dept_name"),
                        result.getString("manager_name")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return null;
    }

    // Lab 4: Retrieve all employees and their current salaries
    public ArrayList<Employee> getAllSalaries() {

        String sql = "SELECT e.emp_no, e.first_name, e.last_name, s.salary " +
                     "FROM employees e " +
                     "JOIN salaries s ON e.emp_no = s.emp_no " +
                     "WHERE s.to_date = '9999-01-01' " +
                     "ORDER BY e.emp_no ASC";

        ArrayList<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                Employee employee = new Employee(
                    result.getInt("emp_no"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getInt("salary")
                );

                employees.add(employee);
            }

            return employees;

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
}
