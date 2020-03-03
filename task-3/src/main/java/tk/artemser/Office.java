package tk.artemser;

import tk.artemser.employees.Employee;

import java.util.List;

public class Office {
    private List<Employee> employees;

    public Office(){}

    public Office(List<Employee> employees){
        this.setEmployees(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
