package tk.sierikov.task4.domain.employees;

import java.util.List;

public class Accountant {
    public static Double summary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();
    }
}
