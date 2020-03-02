package tk.artemser.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Contract {

    private Double salary;
    private Integer neededHours;

    public Contract(){}

    public Contract (Double salary, Integer neededHours){
        this.setSalary(salary);
        this.setNeededHours(neededHours);
    }

    @JsonIgnore
    public Double getSalaryPerHour() {
        return this.salary / this.neededHours;
    }

    public boolean isOvertime(Integer hours){
        return hours > this.neededHours;
    }

    public void setNeededHours(Integer neededHours) {
        if (neededHours <= 0) throw new IllegalArgumentException("NeededHours cannot be 0 or negative.");
        this.neededHours = neededHours;
    }

    public Integer getNeededHours() {
        return this.neededHours;
    }

    public void setSalary(Double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }

    public Double getSalary() {
        return this.salary;
    }
}
