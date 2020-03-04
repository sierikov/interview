package tk.artemser.task4.domain.employees;

import lombok.NoArgsConstructor;
import tk.artemser.contract.Contract;
import tk.artemser.task4.domain.employees.Employee;

@NoArgsConstructor
public class Manager extends Employee {
    public Manager(Contract contract){
        super(contract);
    }

    public Manager(Double salary, Integer neededHours) {
        super(salary, neededHours);
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
