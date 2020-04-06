package tk.sierikov.task4.domain.employees;

import lombok.NoArgsConstructor;
import tk.sierikov.task4.domain.contract.Contract;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Programmer extends Employee {
    public Programmer(Contract contract){
        super(contract);
    }

    public Programmer(Double salary, Integer neededHours) {
        super(salary, neededHours);
        this.setType(EmployeeType.PROGRAMMER);
    }
}
