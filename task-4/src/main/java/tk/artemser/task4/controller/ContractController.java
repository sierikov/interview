package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.ContractDao;
import tk.artemser.task4.domain.contract.Contract;

import java.util.UUID;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractDao contractDao;

    @GetMapping
    public Iterable<Contract> getAll(){
        return contractDao.read();
    }

    @PostMapping
    public void post(@RequestParam UUID id,
                     @RequestParam(required = false) Double salary,
                     @RequestParam(required = false) Integer hours ){
        Contract contract = contractDao.read(id).get();
        if (salary != null) contract.setSalary(salary);
        if (hours != null) contract.setNeededHours(hours);
        contractDao.update(contract);
    }

}
