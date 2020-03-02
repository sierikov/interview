package tk.artemser.employees;

import tk.artemser.contract.Contract;

import java.util.Objects;
import java.util.UUID;

public abstract class Employee {
    private Contract contract;
    private int realHours;
    private UUID uuid;

    Employee(Contract contract) {
        Objects.requireNonNull(contract);
        this.uuid = UUID.randomUUID();
        this.contract = contract;
        this.realHours = 0;
    }

    Employee(int salary, int neededHours){
        this(new Contract(salary, neededHours));
    }

    public double calculateSalary(){
        return this.contract.getSalaryPerHour() * realHours;
    }

    public void addRealHours(int hours) {
        this.realHours += hours;
    }

    public Contract getContract(){
        return this.contract;
    }

    public int getRealHours(){
        return this.realHours;
    }

    /* Only for test purposes */
    public void setUuid(UUID uuid){
        this.uuid = uuid;
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

    @Override
    public String toString() {
        return super.toString() + " " + realHours;
    }
}
