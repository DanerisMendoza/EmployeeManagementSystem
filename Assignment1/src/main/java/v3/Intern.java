package v3;

public class Intern extends Employee implements Trainable{

    public Intern(String name, int id, double baseSalary){
        super(name, id, baseSalary);
    }

    @Override
    public Double calculateSalary(){
        return getBaseSalary()*0.50;
    };

    @Override
    public void attendTraining(){
        System.out.println(super.getName() + " is attending training.");
    }
}
