package tk.artemser.task4.domain.employees;

import lombok.NoArgsConstructor;
import tk.artemser.contract.Contract;

@NoArgsConstructor
public class Programmer extends Employee {

    public Programmer(Contract contract){
        super(contract);
    }

    public Programmer(Double salary, Integer neededHours) {
        super(salary, neededHours);
    }
}
