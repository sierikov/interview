package tk.artemser.employees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import tk.artemser.contract.Contract;

public class ManagerTest {
    private Manager manager;
    private final int SALARY = 100;
    private final int HOURS = 5;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        manager = new Manager(this.SALARY, this.HOURS);
    }

    @Test
    public void testEmployeeConstructorNull() {
        try {
            new Manager(null);
            fail("Contract() cannot accept negative Salary.");
        } catch (NullPointerException ignored) {}
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