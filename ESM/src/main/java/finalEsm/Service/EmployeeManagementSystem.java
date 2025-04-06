package finalEsm.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import finalEsm.Entity.Employee;
import finalEsm.Exception.EmployeeNotFoundException;

public class EmployeeManagementSystem {
    // to store employees with their IDs as keys
    private Map<Integer, Employee> employees1 = new HashMap<>();
    // to store unique employees.
    private Set<Employee> employees2 = new HashSet<>();
    // to maintain the order of employee addition.
    private List<Employee> employees3 = new ArrayList<>();

    public void addEmployee(Employee employee) {
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

    public void displayAllEmployees() {
        for (Employee employee : employees3) {
            System.out.println(employee);
        }
    }

}
