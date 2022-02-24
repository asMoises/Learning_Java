package entities;

public class Employee {
    public String name;
    public double grossSalary;
    public double tax;

    public double NetSalary() {
        return grossSalary -= tax;
    }

    public void IncreaseSalary(double perc) {

        grossSalary += (grossSalary * (perc / 100));
    }
}
