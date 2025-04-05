package v2.Stats;

public class Department {
    private String name;
    private Double sumSalary;
    private Double aveSalary;
    private int length;

    public Department(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(Double sumSalary) {
        this.sumSalary = sumSalary;
    }

    public Double getAveSalary() {
        return aveSalary;
    }

    public void setAveSalary(Double aveSalary) {
        this.aveSalary = aveSalary;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}