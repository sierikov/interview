package tk.sierikov.task4.domain.employees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import tk.sierikov.task4.domain.contract.Contract;

public class ManagerTest {
    private Manager manager;
    private final Double SALARY = 100d;
    private final Integer HOURS = 5;
    private final Double DELTA = 1e-15;

    @Before
    public void setUp() {
        manager = new Manager(this.SALARY, this.HOURS);
    }

    @Test
    public void testEmployeeConstructorNull() {
        try {
            new Manager(null);
            fail("Contract() cannot accept negative Salary.");
        } catch (NullPointerException e) {
            System.out.println("Contract - Invalid Salary checked");
        }
    }

    @Test
    public void testEmployeeConstructor() {
        Contract contract = new Contract(this.SALARY, this.HOURS);
        Manager manager1 = new Manager(contract);
        assertEquals(contract, manager1.getContract());
    }

    @Test
    public void testCalculateSalary() {
        manager.addRealHours(this.HOURS);
        assertEquals(this.SALARY, manager.calculateSalary(), this.DELTA);
    }

    @Test
    public void testCalculateSalaryWithOverTime() {
        manager.addRealHours(this.HOURS + 10);
        assertEquals(this.SALARY, manager.calculateSalary(), this.DELTA);
    }

}