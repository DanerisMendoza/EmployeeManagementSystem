package v3;

public class Manager extends Employee{
    private double bonus;
    public Manager(String name, int id, double baseSalary, double bonus){
       super(name, id, baseSalary);
       this.bonus = bonus;
    }

    @Override
    public Double calculateSalary(){
        return super.getBaseSalary()*bonus;
    };

}
