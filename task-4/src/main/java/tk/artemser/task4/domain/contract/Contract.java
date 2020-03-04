package tk.artemser.task4.domain.contract;

import lombok.*;

@NoArgsConstructor
public class Contract {

    @Getter private Double salary;
    @Getter private Integer neededHours;

    public Contract (Double salary, Integer neededHours){
        this.setSalary(salary);
        this.setNeededHours(neededHours);
    }

    public Double getSalaryPerHour() {
        return this.salary / this.neededHours;
    }

    public boolean isOvertime(Integer hours) {
        return hours > this.neededHours;
    }

    public void setNeededHours(Integer neededHours) {
        if (neededHours <= 0) throw new IllegalArgumentException("NeededHours cannot be 0 or negative.");
        this.neededHours = neededHours;
    }

    public void setSalary(Double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }
}
