package finalEsm;

import java.util.Set;

import finalEsm.Entity.Employee;
import finalEsm.Entity.Manager;
import finalEsm.Service.EmployeeManagementSystem;
import finalEsm.Service.EmployeeManagementSystem.EmployeeCollection;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem esm = new EmployeeManagementSystem();
        Set<String> benefits = Set.of("HMO", "Allowance");
        Employee employee1 = new Manager(1, "karl", "cruz", "it", 3, 60000, benefits, 50000);
        Employee employee2 = new Manager(2, "daneris", "mendoza", "it", 1, 50000, benefits, 40000);
        esm.addEmployee(employee1);
        esm.addEmployee(employee2);
   
        // Display all employee
        esm.displayAllEmployees(EmployeeCollection.list);
        
        // Find employee with id 3
        int searchId = 2;

        try {
            System.out.println("\nSearch id: "+searchId+ esm.getEmployee(searchId));
        } catch (Exception e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }
        
        try {
            esm.removeEmployee(searchId);
        } catch (Exception e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }

        // After employee removal
        System.out.println("\nAfter Employee Removal: ");
        esm.displayAllEmployees(EmployeeCollection.list);
    }
}
