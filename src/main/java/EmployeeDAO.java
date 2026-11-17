
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

    // Lab 3: Retrieve one employee by employee number
    public Employee getEmployee(int ID) {

        String sql = "SELECT e.emp_no, e.first_name, e.last_name, " +
                     "t.title, s.salary, d.dept_no, d.dept_name, " +
                     "m.emp_no AS manager_emp_no, " +
                     "m.first_name AS manager_first_name, " +
                     "m.last_name AS manager_last_name, " +
                     "ms.salary AS manager_salary " +
                     "FROM employees e " +
                     "JOIN titles t ON e.emp_no = t.emp_no " +
                     "JOIN salaries s ON e.emp_no = s.emp_no " +
                     "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                     "JOIN departments d ON de.dept_no = d.dept_no " +
                     "LEFT JOIN dept_manager dm ON d.dept_no = dm.dept_no " +
                     "AND dm.to_date = '9999-01-01' " +
                     "LEFT JOIN employees m ON dm.emp_no = m.emp_no " +
                     "LEFT JOIN salaries ms ON m.emp_no = ms.emp_no " +
                     "AND ms.to_date = '9999-01-01' " +
                     "WHERE e.emp_no = ? " +
                     "AND t.to_date = '9999-01-01' " +
                     "AND s.to_date = '9999-01-01' " +
                     "AND de.to_date = '9999-01-01'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, ID);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {

                    Employee manager = null;

                    if (result.getObject("manager_emp_no") != null) {
                        manager = new Employee(
                            result.getInt("manager_emp_no"),
                            result.getString("manager_first_name"),
                            result.getString("manager_last_name"),
                            result.getInt("manager_salary")
                        );
                    }

                    Department department = new Department();
                    department.dept_no = result.getString("dept_no");
                    department.dept_name = result.getString("dept_name");
                    department.manager = manager;

                    return new Employee(
                        result.getInt("emp_no"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("title"),
                        result.getInt("salary"),
                        department,
                        manager
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

    // Lab 5: Retrieve a department and its manager
    public Department getDepartment(String dept_name) {

        String sql = "SELECT d.dept_no, d.dept_name, " +
                     "m.emp_no AS manager_emp_no, " +
                     "m.first_name AS manager_first_name, " +
                     "m.last_name AS manager_last_name, " +
                     "ms.salary AS manager_salary " +
                     "FROM departments d " +
                     "LEFT JOIN dept_manager dm ON d.dept_no = dm.dept_no " +
                     "AND dm.to_date = '9999-01-01' " +
                     "LEFT JOIN employees m ON dm.emp_no = m.emp_no " +
                     "LEFT JOIN salaries ms ON m.emp_no = ms.emp_no " +
                     "AND ms.to_date = '9999-01-01' " +
                     "WHERE d.dept_name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dept_name);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {

                    Department department = new Department();
                    department.dept_no = result.getString("dept_no");
                    department.dept_name = result.getString("dept_name");

                    if (result.getObject("manager_emp_no") != null) {
                        department.manager = new Employee(
                            result.getInt("manager_emp_no"),
                            result.getString("manager_first_name"),
                            result.getString("manager_last_name"),
                            result.getInt("manager_salary")
                        );
                    }

                    return department;
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return null;
    }

    // Lab 5: Retrieve current salaries by department
    public ArrayList<Employee> getSalariesByDepartment(Department dept) {

        String sql = "SELECT employees.emp_no, employees.first_name, " +
                     "employees.last_name, salaries.salary " +
                     "FROM employees, salaries, dept_emp, departments " +
                     "WHERE employees.emp_no = salaries.emp_no " +
                     "AND employees.emp_no = dept_emp.emp_no " +
                     "AND dept_emp.dept_no = departments.dept_no " +
                     "AND salaries.to_date = '9999-01-01' " +
                     "AND departments.dept_no = ? " +
                     "AND dept_emp.to_date = '9999-01-01' " +
                     "ORDER BY employees.emp_no ASC";

        ArrayList<Employee> employees = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dept.dept_no);

            try (ResultSet result = statement.executeQuery()) {

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
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return null;
        }
    }
}
