package tk.artemser.task4.domain.contract;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Contract {
    private Double salary;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private Integer neededHours;

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
