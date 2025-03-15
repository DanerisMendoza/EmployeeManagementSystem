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
}

