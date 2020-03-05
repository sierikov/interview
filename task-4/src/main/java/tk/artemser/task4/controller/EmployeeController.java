package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.EmployeeDao;
import tk.artemser.task4.domain.employees.Employee;

import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public Iterable<Employee> getAll(){
        return employeeDao.read();
    }

    @PostMapping
    public void post(@RequestParam UUID id,
                     @RequestParam Integer hours){
        Employee employee = employeeDao.read(id).get();
        employee.addRealHours(hours);
        employeeDao.update(employee);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID id){
        Employee employee = employeeDao.read(id).get();
        employeeDao.delete(employee);
    }

}
