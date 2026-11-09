public class Employee {

    private int empNo;
    private String firstName;
    private String lastName;
    private String title;
    private int salary;
    private String department;
    private String manager;

    // Original Lab 3 constructor
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

    // New Lab 4 constructor
    public Employee(int empNo, String firstName, String lastName, int salary) {

        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void displayEmployee() {

        System.out.println("Employee Number: " + empNo);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Job Title: " + title);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Manager: " + manager);
    }
}
