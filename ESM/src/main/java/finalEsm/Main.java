package finalEsm;

import java.util.Set;

import finalEsm.Entity.Employee;
import finalEsm.Entity.Manager;
import finalEsm.Service.EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem esm = new EmployeeManagementSystem();
        Set<String> benefits = Set.of("HMO", "Allowance");
        Employee employee1 = new Manager(1, "karl", "cruz", "it", 3, 60000, benefits, 50000);
        Employee employee2 = new Manager(2, "daneris", "mendoza", "it", 1, 50000, benefits, 40000);
        esm.addEmployee(employee1);
        esm.addEmployee(employee2);
        try {
            int searchId = 3;
            System.out.println("\nSearch id: "+searchId+ esm.getEmployee(searchId));
        } catch (Exception e) {
            System.out.println("\nCaught an exception: " + e.getMessage());
        }
        esm.displayAllEmployees();
    }
}
