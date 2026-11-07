public class Employee {

    private int empNo;
    private String firstName;
    private String lastName;
    private String title;
    private int salary;
    private String department;
    private String manager;

    public Employee(int empNo, String firstName, String lastName,
                    String title, int salary, String department, String manager) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.salary = salary;
        this.department = department;
        this.manager = manager;
    }
}
