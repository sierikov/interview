package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.ProgrammerDao;
import tk.artemser.task4.domain.employees.Programmer;

import java.util.UUID;

@RestController
@RequestMapping("/programmer")
public class ProgrammerController {

    @Autowired
    private ProgrammerDao programmerDao;

    @GetMapping
    public Iterable<Programmer> getAll(){
        return programmerDao.read();
    }

    @PutMapping
    public void put(@RequestParam Double salary,
                     @RequestParam Integer neededHours){
        programmerDao.create(new Programmer(salary, neededHours));
    }

    @PostMapping
    public void post(@RequestParam UUID id,
                     @RequestParam Integer hours){
        Programmer programmer = programmerDao.read(id).get();
        programmer.addRealHours(hours);
        programmerDao.update(programmer);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID id){
        Programmer programmer = programmerDao.read(id).get();
        programmerDao.delete(programmer);
    }

}
