package tk.artemser;

import org.junit.Before;
import org.junit.Test;
import tk.artemser.contract.Contract;
import tk.artemser.employees.Employee;
import tk.artemser.employees.Manager;
import tk.artemser.employees.Programmer;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JsonDataManagerTest {
    private Manager manager;
    private Programmer programmer;
    private List<Employee> employees;
    private JsonDataManager jsonDataManager;
    private final String FILE_PROGRAMMER = "./data/programmer.json";
    private final String FILE_MANAGER = "./data/manager.json";
    private final String FILE_EMPLOYEES = "./data/employees.json";

    @Before
    public void setUp() {
        this.jsonDataManager = new JsonDataManager();
        this.manager = new Manager(new Contract(10d, 10));
        this.programmer = new Programmer(new Contract(10d, 10));
        this.employees = Arrays.asList(this.programmer, this.manager);
    }


    public void testWrite() {
        assertTrue(jsonDataManager.write(Arrays.asList(programmer), FILE_PROGRAMMER));
        assertTrue(jsonDataManager.write(Arrays.asList(manager), FILE_MANAGER));
    }


    public void testRead() {
        Manager manager = (Manager) jsonDataManager.read(FILE_MANAGER).get().get(0);
        assertEquals(this.manager, manager);

        Programmer programmer = (Programmer) jsonDataManager.read(FILE_PROGRAMMER).get().get(0);
        assertEquals(this.programmer, programmer);
    }

    public void testWriteList() {
        assertTrue(jsonDataManager.write(this.employees, FILE_EMPLOYEES));
    }

    public void testReadList() {
        assertEquals(this.employees, jsonDataManager
                .read(FILE_EMPLOYEES)
                .get());
    }

    @Test
    public void testReadAndWrite() {
        this.testWrite();
        this.testRead();
    }

    @Test
    public void testReadAndWriteLists() {
        this.testWriteList();
        this.testReadList();
    }
}
