package v3;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EmployeeManager  {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Optional<Employee> getEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void removeEmployeeByEmployeeId(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

}

