package tk.artemser.employees;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tk.artemser.contract.Contract;

import java.util.Objects;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class, name = "Manager"),
        @JsonSubTypes.Type(value = Programmer.class, name = "Programmer")
})
public abstract class Employee {
    private Contract contract;
    private Integer realHours;
    private UUID uuid;

    Employee(){}

    Employee(Contract contract) {
        Objects.requireNonNull(contract);
        this.uuid = UUID.randomUUID();
        this.contract = contract;
        this.realHours = 0;
    }

    Employee(Double salary, Integer neededHours){
        this(new Contract(salary, neededHours));
    }

    public double calculateSalary(){
        return this.contract.getSalaryPerHour() * realHours;
    }

    public void addRealHours(Integer hours) {
        this.realHours += hours;
    }

    public void setRealHours(Integer realHours) {
        this.realHours = realHours;
    }

    public Contract getContract(){
        return this.contract;
    }

    public void setContract(Contract contract){
        this.contract = contract;
    }

    public Integer getRealHours(){
        return this.realHours;
    }

    public UUID getUuid(){
        return this.uuid;
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
