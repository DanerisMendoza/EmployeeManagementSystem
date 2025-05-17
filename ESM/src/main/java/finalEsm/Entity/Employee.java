package finalEsm.Entity;

import java.util.Set;

public abstract class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private int yearOfServices;
    private double salary;
    private Set<String> benefits;
    private double bonus;

    public Employee(int id, String firstName, String lastName, String department, int yearOfServices, double salary,
            Set<String> benefits, double bonus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.yearOfServices = yearOfServices;
        this.salary = salary;
        this.benefits = benefits;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public double getYearOfServices() {
        return yearOfServices;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public Set<String> getBenefits() {
        return benefits;
    }

    @Override
    public String toString() {
        return "\n{ " +
                "ID: " + id + ", " +
                "Name: " + firstName + " " + lastName + ", " +
                "Department: " + department + ", " +
                "Total Compensation: " + calculateTotalCompensation() +
                " }";
    }

    public abstract double calculateTotalCompensation();

}
