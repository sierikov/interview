package tk.artemser.employees;

import tk.artemser.contract.Contract;

public class Programmer extends Employee {

    public Programmer(Contract contract){
        super(contract);
    }

    public Programmer(int salary, int neededHours) {
        super(salary, neededHours);
    }
}
