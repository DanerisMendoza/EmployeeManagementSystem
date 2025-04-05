package v2.EmployeeManagementSystem;


import v2.Employee;

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
        System.out.println();
        checkRetirementEligibility();
        System.out.println();
        departmentsInformation();
        System.out.println();
        projectedSalary();
        System.out.println();
        employeeIdValidation();
        System.out.println();
        simulatePayrollProcessing();

    }

    public void checkRetirementEligibility() {
        employees.forEach((employee)->{
            if(employee.getAge() >= 60){
                System.out.println(employee.getName()+" is eligible for retirement");
            }else{
                System.out.println(employee.getName()+" is not eligible for retirement");
            }
        });
    }

    public void departmentsInformation(){
        employees.forEach((employee -> {
            String department = employee.getDepartment().toLowerCase();
            switch (department){
                case "it":
                    System.out.println(department.toUpperCase()+" Department: Responsible for maintaining computer systems and networks.");
                    break;
                case "hr":
                    System.out.println(department.toUpperCase()+" Department: Responsible for human resources.");
                    break;
                case "admin":
                    System.out.println(department.toUpperCase()+" Department: Responsible for administration.");
                    break;
            }
        }));
    }

    public void projectedSalary(){
        for(Employee employee : employees){
            System.out.println("Projected salary for "+employee.getName()+" over 5 years:");
            double salaryComputed = employee.getSalary();
            for (int i=1; i<=5; i++){
                System.out.printf("Year %d: PHP %.2f %n",i, salaryComputed);
                salaryComputed *= 1.05;
            }
            System.out.println();
        }
    }

    public void employeeIdValidation(){
        employees.forEach((employee -> {
            System.out.println("Employee ID "+employee.getEmployeeId()+" is valid.");
        }));
    }

    public void simulatePayrollProcessing(){
        int i =0;
        do {
            System.out.println("Processing payroll for employee "+employees.get(i).getEmployeeId());
            i++;
        }while (i<employees.size());
        System.out.println("Payroll processing completed for "+employees.size()+" employees.");
    }

}

