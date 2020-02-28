package tk.artemser.contract;

public class Contract {

    private double salary;
    private int neededHours;

    public Contract (double salary, int neededHours){
        this.setSalary(salary);
        this.setNeededHours(neededHours);
    }

    public double getSalaryPerHour() {
        return this.salary / this.neededHours;
    }

    public boolean isOvertime(int hours){
        return hours > this.neededHours;
    }

    public void setNeededHours(int neededHours) {
        if (neededHours <= 0) throw new IllegalArgumentException("NeededHours cannot be 0 or negative.");
        this.neededHours = neededHours;
    }

    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}
