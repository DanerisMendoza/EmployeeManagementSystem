package finalEsm.Entity;

import java.util.Set;

public class Manager extends Employee {

    public Manager(int id, String firstName, String lastName, String department, int yearOfServices, double salary,
            Set<String> benefits, double bonus) {
        super(id, firstName, lastName, department, yearOfServices, salary, benefits, bonus);
    }

}
