package tk.artemser.task4.domain.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ContractTest {
    private Contract contract;
    private final Double SALARY = 100d;
    private final Integer HOURS = 5;
    private final Double DELTA = 1e-15;

    @Before
    public void setUp() {
        contract = new Contract(this.SALARY, this.HOURS);
    }

    @Test
    public void testConstructorInvalidSalary() {
        try {
            new Contract(-40d, 40);
            fail("Contract() cannot accept negative Salary.");
        } catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testConstructorInvalidHours() {
        try {
            new Contract(12d, -23);
            fail("Contract() cannot accept negative Hours.");
        } catch (IllegalArgumentException ignored) {}

        try {
            new Contract(12d, 0);
            fail("Contract() cannot accept negative Hours.");
        } catch (IllegalArgumentException ignored) {}
    }

    @Test
    public void testGetSalaryPerHour() {
        assertEquals(20, this.contract.getSalaryPerHour(), this.DELTA);
    }

    @Test
    public void testGetSalary() {
        assertEquals(this.SALARY, this.contract.getSalary(), this.DELTA);
    }

    @Test
    public void testIsOverTime() {
        assertTrue(this.contract.isOvertime(this.HOURS + 10));
        assertFalse(this.contract.isOvertime(this.HOURS - 10));
    }
}
