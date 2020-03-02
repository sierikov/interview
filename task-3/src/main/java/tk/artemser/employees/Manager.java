package tk.artemser.employees;

import tk.artemser.contract.Contract;

public class Manager extends Employee {

    public Manager(){}

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
