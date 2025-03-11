package Employee;

public class Employee {
    private String Name;
    private int Age;
    private long EmployeeId;
    private String Department;
    private double Salary;
    private Boolean IsReadyForRetire;

    //pojo constructor
    public Employee(
            String Name,
            int Age,
            long EmployeeId,
            String Department,
            double Salary,
            Boolean IsReadyForRetire
    ){
        this.Name = Name;
        this.Age = Age;
        this.Department = Department;
        this.Salary = Salary;
        this.IsReadyForRetire = IsReadyForRetire;
    }

    //java bean (no argument constructor)
    public Employee(){}

    //getter and setter (required in java bean)


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public boolean isReadyForRetire() {
        return IsReadyForRetire;
    }

    public void setReadyForRetire(Boolean readyForRetire) {
        IsReadyForRetire = readyForRetire;
    }



}
