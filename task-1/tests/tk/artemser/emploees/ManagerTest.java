package tk.artemser.emploees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
    public void testCalculateSalary(){
        manager.addRealHours(this.HOURS);
        assertEquals(this.SALARY, manager.calculateSalary(), this.DELTA);
    }

    @Test
    public void testCalculateSalaryWithOverTime(){
        manager.addRealHours(this.HOURS + 10);
        assertEquals(this.SALARY, manager.calculateSalary(), this.DELTA);
    }

}