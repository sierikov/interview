package tk.artemser;

import org.junit.Before;
import org.junit.Test;
import tk.artemser.contract.Contract;
import tk.artemser.employees.Employee;
import tk.artemser.employees.Manager;
import tk.artemser.employees.Programmer;

import java.util.*;

import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void testIsVowel() {
        String vowels = "aeiou";
        for (char ch : vowels.toCharArray()) {
            assertTrue(Utils.isVowel(ch));
        }
        assertFalse(Utils.isVowel('z'));
    }

    @Test
    public void testInterviewRecursion() {
        assertEquals("h*e*ll*o", Utils.interviewRecursionTest("hello"));
        assertEquals("h*e*a*l*o", Utils.interviewRecursionTest("healo"));
        assertEquals("a*bc", Utils.interviewRecursionTest("abc"));
        assertEquals("o*a*b", Utils.interviewRecursionTest("oab"));
    }

    @Test
    public void testToBinary() {
        assertEquals("011001100110111101101111", Utils.toBinary("foo"));
        assertEquals("01000111", Utils.toBinary("G"));
    }

    @Test
    public void testConverter() {
        assertEquals("00 0 0 0 00 000 0 000", Utils.converter("G"));
    }

    @Test
    public void testMergeEmployees() {
        Contract defaultContract = new Contract(10, 10);
        UUID testID = UUID.randomUUID();
        Programmer p = new Programmer(defaultContract);
        p.setUuid(testID);
        p.addRealHours(12);

        Programmer p1 = new Programmer(defaultContract);
        p1.setUuid(testID);
        p1.addRealHours(10);

        List<Employee> e = Arrays.asList(p, new Programmer(defaultContract), new Programmer(defaultContract));
        List<Employee> e1 = Arrays.asList(p1, new Manager(defaultContract), new Manager(defaultContract));
        List<Employee> employees = Utils.mergeEmployees(e, e1);
        assertEquals(3, employees.size());
        assertEquals(e1, employees);
        assertEquals(e1.get(e1.indexOf(p1)), employees.get(employees.indexOf(p1)));
    }
}
