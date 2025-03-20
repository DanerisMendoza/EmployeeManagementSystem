package v3;

public class Developer extends Employee implements Trainable{
    private double techBonus;
    public Developer(String name, int id, double baseSalary, double techBonus){
        super(name, id, baseSalary);
        this.techBonus = techBonus;
    }

    @Override
    public Double calculateSalary(){
        return super.getBaseSalary() + techBonus;
    };

    @Override
    public void attendTraining(){
        System.out.println(super.getName() + " is attending training.");
    }
}
