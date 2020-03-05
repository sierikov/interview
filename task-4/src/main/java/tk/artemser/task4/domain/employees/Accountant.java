package tk.artemser.task4.domain.employees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Accountant {
    public static double summary(List<Employee> employees) {
        double salarySum = employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .sum();
        return BigDecimal.valueOf(salarySum)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
