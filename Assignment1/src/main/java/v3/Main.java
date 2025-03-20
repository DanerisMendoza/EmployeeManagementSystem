package v3;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager ();
        em = populateEm(em);
        displayAllEmployee(em);

        //check getEmployee
        Employee result = em.getEmployee(3)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + 3));
        System.out.print("Get employee by id of 3");
        result.displayInfo();


        //check remove function
        em.removeEmployeeByEmployeeId(3);
        System.out.println();
        System.out.println("Removing Employee Dane...");
        result = em.getEmployee(3)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + 3));
        System.out.println("Get employee by id of "+ result.getName());
    }

    public static EmployeeManager populateEm(EmployeeManager em){
        em.addEmployee(new Manager("Carl",1,50000,1.20));
        em.addEmployee(new Developer("Bry",2,30000,500));
        em.addEmployee(new Intern("Dane",3,2000));
        return em;
    }

    public static void displayAllEmployee(EmployeeManager em){
        System.out.println("----------------------------------");
        System.out.println("Display All Employee");
        em.getEmployees().forEach((Employee employee)->{
            employee.displayInfo(); //concrete method
            System.out.printf("Calculated Salary: %.2f %n",employee.calculateSalary()); //abstract method
            employee.attendTraining();
        });
        System.out.println("----------------------------------");
    }
}