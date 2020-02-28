package tk.artemser.employees;

import tk.artemser.contract.Contract;

import java.util.Objects;

abstract class Employee {
    private Contract contract;
    private int realHours;

    Employee(Contract contract) {
        Objects.requireNonNull(contract);
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

}
