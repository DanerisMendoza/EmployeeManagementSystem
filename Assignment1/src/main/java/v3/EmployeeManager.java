package v3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeManager  {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Employee not found with ID: " + id));
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void removeEmployeeByEmployeeId(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

}

