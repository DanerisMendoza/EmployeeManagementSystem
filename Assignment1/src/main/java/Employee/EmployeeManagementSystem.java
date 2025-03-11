package Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void removeEmployeeByName(String name){
        employees.removeIf(employee -> employee.getName().equals(name));
    }

    public void instructions(){
        checkRetirementEligibility();
    }

    public void checkRetirementEligibility(){
        boolean anyEligible = false;
        List<Employee> employeeEligible = new ArrayList<>();
        int retirementAge = 65;
        for (Employee employee: employees){
            if(employee.getAge() >= retirementAge){
                anyEligible = true;
                employeeEligible.add(employee);
            }
        }
        System.out.println("\nRetirement Eligibility:");
        System.out.println("Is anyone eligible for retirement? " + anyEligible);
        System.out.println("Employees eligible for retirement: ");
        for (Employee employee : employeeEligible){
            System.out.println(employee.getName());
        }
    }

}
