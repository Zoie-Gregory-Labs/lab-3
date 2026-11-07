import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public Employee getEmployee(int ID) {

        String sql = "SELECT e.emp_no, e.first_name, e.last_name, " +
                     "t.title, s.salary, d.dept_name " +
                     "FROM employees e " +
                     "JOIN titles t ON e.emp_no = t.emp_no " +
                     "JOIN salaries s ON e.emp_no = s.emp_no " +
                     "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                     "JOIN departments d ON de.dept_no = d.dept_no " +
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
                        "Not retrieved yet"
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return null;
    }
}
