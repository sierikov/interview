package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.ManagerDao;
import tk.artemser.task4.domain.employees.Manager;

import java.util.UUID;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerDao managerDao;

    @GetMapping
    public Iterable<Manager> getAll(){
        return managerDao.read();
    }

    @PutMapping
    public void put(@RequestParam(required = true) Double salary,
                     @RequestParam(required = true) Integer neededHours){
        managerDao.create(new Manager(salary, neededHours));
    }

    @PostMapping
    public void post(@RequestParam UUID id,
                     @RequestParam Integer hours){
        Manager manager = managerDao.read(id).get();
        manager.addRealHours(hours);
        managerDao.update(manager);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID id){
        Manager manager = managerDao.read(id).get();
        managerDao.delete(manager);
    }

}
