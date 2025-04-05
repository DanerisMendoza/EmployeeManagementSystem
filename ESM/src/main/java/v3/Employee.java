package v3;

public abstract class Employee {
    private String name;
    private int id;
    private double baseSalary;

    public Employee(String name, int id, double baseSalary){
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    //concrete method
    public void displayInfo(){
        System.out.println();
        System.out.println("Name: "+ name);
        System.out.println("Id: "+ id);
        System.out.println("Class Name: "+this.getClass().getSimpleName());
        System.out.printf("Base Salary: %.2f %n", baseSalary);
    }

    //abstract method
    public abstract Double calculateSalary();

    public void attendTraining() {
        System.out.println(name + " does not need training.");
    }
}
