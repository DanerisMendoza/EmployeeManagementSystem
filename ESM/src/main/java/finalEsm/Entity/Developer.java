package finalEsm.Entity;

import java.util.Set;

public class Developer extends Employee {

    public Developer(int id, String firstName, String lastName, String department, int yearOfServices, double salary,
            Set<String> benefits, double bonus) {
        super(id, firstName, lastName, department, yearOfServices, salary, benefits, bonus);
    }
}
