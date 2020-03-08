package tk.artemser.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.artemser.task4.dao.ContractDao;

import java.util.UUID;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractDao contractDao;

    @GetMapping
    public ResponseEntity getAll(){
        return new ResponseEntity<>(contractDao.read(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable UUID id){
        return contractDao.read(id).map(
                contract -> new ResponseEntity<>(contract, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PutMapping("/id/{id}")
    public ResponseEntity post(@PathVariable UUID id,
                     @RequestParam(required = false) Double salary,
                     @RequestParam(required = false) Integer hours ){
        return contractDao.update(id, salary, hours).map(
                contract1 -> new ResponseEntity<>(contract1, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

}
