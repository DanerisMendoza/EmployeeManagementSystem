package v3;

public class Main {
    public static void main(String[] args) {
        EmployeeManager  esm = new EmployeeManager ();
        esm.addEmployee(new Manager("Carl",1,50000,1.20));
        esm.addEmployee(new Developer("Bry",2,30000,500));
        esm.addEmployee(new Intern("Dane",3,2000));
        esm.getEmployees().forEach((Employee employee)->{
            employee.displayInfo(); //concrete method
            System.out.printf("Calculated Salary: %.2f %n",employee.calculateSalary()); //abstract method
            employee.attendTraining();
        });
    }


}