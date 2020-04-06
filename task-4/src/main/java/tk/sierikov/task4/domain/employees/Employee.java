package tk.sierikov.task4.domain.employees;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import tk.sierikov.task4.domain.contract.Contract;

import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;
    private Integer realHours;
    private EmployeeType type;

    Employee(Contract contract) {
        Objects.requireNonNull(contract);
        this.contract = contract;
        this.realHours = 0;
    }

    Employee(Double salary, Integer neededHours) {
        this(new Contract(salary, neededHours));
    }

    public Double calculateSalary() {
        return this.contract.getSalaryPerHour() * realHours;
    }

    public void addRealHours(Integer hours) {
        this.realHours += hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return this.id.equals(e.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

}
