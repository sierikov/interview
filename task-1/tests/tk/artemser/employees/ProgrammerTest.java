package tk.artemser.employees;

import org.junit.Before;
import org.junit.Test;
import tk.artemser.contract.Contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProgrammerTest {
    private Programmer programmer;
    private final int SALARY = 100;
    private final int HOURS = 5;
    private final double DELTA = 1e-15;

    @Before
    public void setUp() {
        programmer = new Programmer(this.SALARY, this.HOURS);
    }

    @Test
    public void testEmployeeConstructorNull(){
        try {
            new Programmer(null);
            fail("Contract() cannot accept negative Salary.");
        } catch (NullPointerException e) {
            System.out.println("Contract - Invalid Salary checked");
        }
    }

    @Test
    public void testEmployeeConstructor() {
        Contract contract = new Contract(this.SALARY, this.HOURS);
        Programmer programmer1 = new Programmer(contract);
        assertEquals(contract, programmer1.getContract());
    }

    @Test
    public void testCalculateSalary(){
        programmer.addRealHours(this.HOURS);
        assertEquals(this.SALARY, programmer.calculateSalary(), this.DELTA);
    }

    @Test
    public void testCalculateSalaryWithOverTime(){
        programmer.addRealHours(this.HOURS * 2);
        assertEquals(this.SALARY * 2, programmer.calculateSalary(), this.DELTA);
    }
}
