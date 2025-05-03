package finalEsm.Entity;

import java.util.Set;

public class Developer extends Employee {

    public Developer(int id, String firstName, String lastName, String department, int yearOfServices, double salary, Set<String> benefits, double bonus) {
        super(id, firstName, lastName, department, yearOfServices, salary, benefits, bonus);
    }

    public double calculateTotalCompensation(){
            // Managers get a service bonus of 2% of their salary for each year of service
            double bonus = getSalary() * 0.02 * getYearOfServices();
            return getSalary() + getBonus() + bonus;
    }
}
