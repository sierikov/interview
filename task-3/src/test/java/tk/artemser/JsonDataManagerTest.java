package tk.artemser;

import org.junit.Before;
import org.junit.Test;
import tk.artemser.contract.Contract;
import tk.artemser.employees.Employee;
import tk.artemser.employees.Manager;
import tk.artemser.employees.Programmer;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.*;

public class JsonDataManagerTest {
    private Manager manager;
    private Programmer programmer;
    private JsonDataManager<Manager> jsonDataManager;
    private JsonDataManager<Programmer> jsonDataProgrammer;
    private final String FILE_PROGRAMMERS = "./data/programmers.json";
    private final String FILE_MANAGERS = "./data/managers.json";

    @Before
    public void setUp(){
        this.jsonDataManager = new JsonDataManager<>();
        this.jsonDataProgrammer = new JsonDataManager<>();
        this.manager = new Manager(new Contract(10d, 10));
        this.programmer = new Programmer(new Contract(10d, 10));
    }


    public void testWrite(){
        assertTrue(jsonDataProgrammer.write(programmer, FILE_PROGRAMMERS));
        assertTrue(jsonDataManager.write(manager, FILE_MANAGERS));
    }


    public void testRead(){
        Manager manager = jsonDataManager.read(FILE_MANAGERS).get();
        assertEquals(this.manager, manager);

        Programmer programmer = jsonDataProgrammer.read(FILE_PROGRAMMERS).get();
        assertEquals(this.programmer, programmer);
    }

    @Test
    public void testReadAndWrite(){
        this.testWrite();
        this.testRead();
    }
}
