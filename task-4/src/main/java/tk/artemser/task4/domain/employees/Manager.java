package tk.artemser.task4.domain.employees;

import lombok.NoArgsConstructor;
import tk.artemser.task4.domain.contract.Contract;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
public class Manager extends Employee {
    public Manager(Contract contract){
        super(contract);
    }

    public Manager(Double salary, Integer neededHours) {
        super(salary, neededHours);
        this.setType(EmployeeType.MANAGER);
    }

    @Override
    public double calculateSalary() {
        boolean isOvertime = super.getContract().isOvertime(super.getRealHours());
        if (isOvertime){
            return super.getContract().getSalary();
        }
        return super.calculateSalary();
    }
}
