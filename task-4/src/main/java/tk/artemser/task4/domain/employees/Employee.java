package tk.artemser.task4.domain.employees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.*;
import tk.artemser.contract.Contract;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
public abstract class Employee {
    @Getter @Setter private Contract contract;
    @Getter @Setter private Integer realHours;
    @Getter @Setter private UUID uuid;

    Employee(Contract contract) {
        Objects.requireNonNull(contract);
        this.uuid = UUID.randomUUID();
        this.contract = contract;
        this.realHours = 0;
    }

    Employee(Double salary, Integer neededHours) {
        this(new Contract(salary, neededHours));
    }

    public double calculateSalary() {
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
        return this.uuid.equals(e.uuid);
    }

    @Override
    public int hashCode() {
        return this.uuid.hashCode();
    }
}
