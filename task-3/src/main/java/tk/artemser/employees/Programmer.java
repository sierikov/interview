package tk.artemser.employees;

import tk.artemser.contract.Contract;

public class Programmer extends Employee {

    public Programmer(){}
    public Programmer(Contract contract){
        super(contract);
    }

    public Programmer(Double salary, Integer neededHours) {
        super(salary, neededHours);
    }
}
