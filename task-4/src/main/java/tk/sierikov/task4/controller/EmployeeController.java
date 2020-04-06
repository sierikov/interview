package tk.sierikov.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.sierikov.task4.dao.EmployeeDao;
import tk.sierikov.task4.domain.employees.EmployeeType;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public ResponseEntity get() {
        return new ResponseEntity<>(employeeDao.read(), HttpStatus.OK);
    }

    @GetMapping("/{type}")
    public ResponseEntity getByType(@PathVariable EmployeeType type) {
        return employeeDao.read(type).map(
                employees -> new ResponseEntity<>(employees, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping("/{type}")
    public ResponseEntity postByType(@PathVariable EmployeeType type,
                                     @RequestParam Double salary,
                                     @RequestParam Integer neededHours) {
        return employeeDao.create(type, salary, neededHours).map(
                e -> new ResponseEntity<>(e, HttpStatus.CREATED)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return employeeDao.read(id).map(
                employee -> new ResponseEntity<>(employee, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PutMapping("/id/{id}")
    public ResponseEntity postById(@PathVariable UUID id,
                                   @RequestParam Integer hours) {
        return employeeDao.update(id, hours).map(
                employee -> new ResponseEntity<>(employee, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        return employeeDao.delete(id) ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
