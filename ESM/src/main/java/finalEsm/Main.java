package finalEsm;

import java.io.IOException;
import java.util.Set;

import finalEsm.Entity.Employee;
import finalEsm.Entity.Manager;
import finalEsm.Exception.DuplicateEmployeeException;
import finalEsm.Exception.EmployeeNotFoundException;
import finalEsm.Service.EmployeeManagementSystem;
import finalEsm.Service.EmployeeManagementSystem.EmployeeCollection;
import finalEsm.Loader.*;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem esm = new EmployeeManagementSystem();
        Set<String> benefits = Set.of("HMO", "Allowance");
        Employee employee1 = new Manager(1, "karl", "cruz", "it", 3, 60000, benefits, 50000);
        Employee employee2 = new Manager(2, "daneris", "mendoza", "it", 1, 50000, benefits, 40000);
        System.out.println("-----\n");

        // Add Empoloyee
        try {
            esm.addEmployee(employee1);
            esm.addEmployee(employee2);
        } catch (DuplicateEmployeeException e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }
            
        // seeder
        try {
            Loader.loadFromExcel("employees.xlsx", esm);    
        } catch (IOException e) {
            System.out.println("Failed to load employees from Excel: " + e.getMessage());
        }

        // Display all employee
        esm.displayAllEmployees(EmployeeCollection.list);
        
        // Find employee by id
        int searchId = 2;
        try {
            System.out.println("\nSearch id: "+searchId+ esm.getEmployee(searchId));
        } catch (EmployeeNotFoundException e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }
        
        // Remove employee by id
        try {
            esm.removeEmployee(searchId);
        } catch (EmployeeNotFoundException e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }

        // After employee removal
        System.out.println("\nAfter Employee Removal: ");
        esm.displayAllEmployees(EmployeeCollection.list);
        
        // Calculate Total Payroll
        System.out.println("\nCalculate Total Payroll: ");
        esm.calculateTotalPayroll(EmployeeCollection.list);
    }
}
