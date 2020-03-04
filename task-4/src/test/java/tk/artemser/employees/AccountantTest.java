package tk.artemser.employees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import tk.artemser.contract.Contract;

import java.util.ArrayList;
import java.util.List;

public class AccountantTest {
    private List<Employee> employees;
    private final Double SALARY = 100d;
    private final int HOURS = 5;
    private final int EMPLOYEE_AMOUNT = 40;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        Contract defaultContract = new Contract(this.SALARY, this.HOURS);
        this.employees = new ArrayList<>();
        for (int i = 0; i < this.EMPLOYEE_AMOUNT; ++i) {
            if ( i % 2 == 0) employees.add(new Manager(defaultContract));
            else employees.add(new Programmer(defaultContract));
        }
        employees.forEach(e -> e.addRealHours(this.HOURS));
    }

    @Test
    public void testSummary() {
        assertEquals(this.SALARY * this.EMPLOYEE_AMOUNT, Accountant.summary(this.employees), this.DELTA);
    }

    @Test
    public void testSummaryWithOvertime() {
        employees.forEach(e -> e.addRealHours(this.HOURS));
        double programmersSalary = this.SALARY * (this.EMPLOYEE_AMOUNT >> 1) * 2;
        double managersSalary = this.SALARY * (this.EMPLOYEE_AMOUNT >> 1);
        double summary = programmersSalary + managersSalary;
        assertEquals(summary, Accountant.summary(this.employees), this.DELTA);
    }
}
