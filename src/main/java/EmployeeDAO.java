import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

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

    public ArrayList<Employee> getAllSalaries() {

        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT employees.emp_no, employees.first_name, " +
                     "employees.last_name, salaries.salary " +
                     "FROM employees, salaries " +
                     "WHERE employees.emp_no = salaries.emp_no " +
                     "AND salaries.to_date = '9999-01-01' " +
                     "ORDER BY employees.emp_no ASC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                employees.add(new Employee(
                    result.getInt("emp_no"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getInt("salary")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return employees;
    }
}
