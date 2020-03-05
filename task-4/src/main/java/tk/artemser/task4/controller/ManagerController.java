package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.ManagerDao;
import tk.artemser.task4.domain.employees.Manager;
import tk.artemser.task4.repository.ManagerRepo;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    // TODO: POST - Update
    // TODO: DEL - Delete

    @Autowired
    private ManagerDao managerDao;

    @GetMapping
    public Iterable<Manager> getAll(){
        return managerDao.read();
    }

    @PutMapping
    public void post(@RequestParam(required = true) Double salary,
                     @RequestParam(required = true) Integer neededHours){
        managerDao.create(new Manager(salary, neededHours));
    }

}
