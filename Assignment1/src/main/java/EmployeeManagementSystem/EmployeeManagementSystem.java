package EmployeeManagementSystem;


import Employee.Employee;
import Stats.Department;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void removeEmployeeByName(String name) {
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public void instructions() {
        checkRetirementEligibility();
        System.out.println();
        averageSalaryPerDepartment();
        System.out.println();
        averageAge();
        System.out.println();
        giveRaise();

    }

    public void checkRetirementEligibility() {
        boolean anyEligible = false;
        List<Employee> employeeEligible = new ArrayList<>();
        List<Employee> employeeNotEligible = new ArrayList<>();
        int retirementAge = 65;
        for (Employee employee : employees) {
            if (employee.getAge() >= retirementAge) {
                anyEligible = true;
                employeeEligible.add(employee);
            } else {
                employeeNotEligible.add(employee);
            }
        }
        System.out.println("\nRetirement Eligibility:");
        System.out.println("Is anyone eligible for retirement? " + anyEligible);
        System.out.println("Employees eligible for retirement: ");
        for (Employee employee : employeeEligible) {
            System.out.println("- " + employee.getName());
        }
        System.out.println("Employees are not eligible for retirement: ");
        for (Employee employee : employeeNotEligible) {
            System.out.println("- " + employee.getName());
        }
    }

    public void averageSalaryPerDepartment(){
        ArrayList<Department> departmentStats = new ArrayList<>();
        employees.forEach(employee -> {
            // Check if department exists
            Department dept = departmentStats.stream()
                    .filter(d -> d.getName().equals(employee.getDepartment()))
                    .findFirst()
                    .orElse(null);

            if (dept == null) {
                // If department doesn't exist, create a new one
                dept = new Department();
                dept.setName(employee.getDepartment());
                dept.setSumSalary(0.0);
                dept.setLength(0);
                departmentStats.add(dept);
            }

            // Update department salary and length
            dept.setSumSalary(dept.getSumSalary() + employee.getSalary());
            dept.setLength(dept.getLength() + 1);
            dept.setAveSalary(dept.getSumSalary() / dept.getLength());
        });

        System.out.println("Average Salary Per Department");
        departmentStats.forEach(department -> {
            System.out.println(department.getName()+": "+department.getAveSalary());
        });

    }

    public void averageAge(){
        int sum = 0;
        for(Employee employee : employees){
            sum+=employee.getAge();
        }
        System.out.println("Average age of all employees");
        System.out.println("Average age: "+(sum/employees.size()));
    }

    public void giveRaise() {
        System.out.println("5% raise to all employees except those with a salary of 50k");

        System.out.println("\nBefore:");
        employees.forEach(employee ->
            System.out.printf("%s: %.2f PHP%n", employee.getName(), employee.getSalary())
        );
        // Apply raise (modify salary)
        employees.forEach(employee -> {
            if (employee.getSalary() < 50000) { // Only update if salary is below 50k
                employee.setSalary(employee.getSalary() * 1.05); // Increase by 5%
            }
        });

        System.out.println("\nAfter:");
        employees.forEach(employee ->
                System.out.printf("%s: %.2f PHP%n", employee.getName(), employee.getSalary())
        );
    }

}

