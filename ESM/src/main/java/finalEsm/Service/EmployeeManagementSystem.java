package finalEsm.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import finalEsm.Entity.Employee;
import finalEsm.Exception.DuplicateEmployeeException;
import finalEsm.Exception.EmployeeNotFoundException;

public class EmployeeManagementSystem {
    // to store employees with their IDs as keys
    private Map<Integer, Employee> employees1 = new HashMap<>();
    // to store unique employees.
    private Set<Employee> employees2 = new HashSet<>();
    // to maintain the order of employee addition.
    private List<Employee> employees3 = new ArrayList<>();

    public enum EmployeeCollection {
        map,
        set,
        list
    }

    public void displayAllEmployees(EmployeeCollection ec) {
        switch (ec) {
            case map:
                System.out.print("Employees1 : Map");
                for (Map.Entry<Integer, Employee> employee : employees1.entrySet()) {
                    System.out.println("\n"+employee);
                }
                break;
            case set:
                System.out.print("Employees1 : Set");
                for (Employee employee : employees2) {
                    System.out.println(employee);
                }
                break;
            case list:
                System.out.print("Employees3 : ArrayList");
                for (Employee employee : employees3) {
                    System.out.println(employee);
                }
                break;
            default:
                System.out.println("Unknown collection type");
                break;
        }
    }

    public void calculateTotalPayroll(){
        
    }
    
    public void addEmployee(Employee employee) throws DuplicateEmployeeException{
        if (employees1.containsKey(employee.getId()) || employees2.contains(employee) || employees3.contains(employee)){
            throw new DuplicateEmployeeException("Employee with ID "+employee.getId()+" Already Exist");
        }

        employees1.put(employee.getId(), employee);
        employees2.add(employee);
        employees3.add(employee);
    }

    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        for (Employee employee : employees2) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    public void removeEmployee(int employeeId) throws EmployeeNotFoundException {
        Employee employee = getEmployee(employeeId);
        employees1.remove(employeeId);
        employees2.remove(employee);
        employees3.remove(employee);
    }

}
