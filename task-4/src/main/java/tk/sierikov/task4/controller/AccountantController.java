package tk.sierikov.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.sierikov.task4.service.AccountantService;

import java.util.UUID;

@RestController
@RequestMapping("/accountant")
public class AccountantController {

    @Autowired
    private AccountantService accountantService;

    @GetMapping
    public ResponseEntity get() {
        return new ResponseEntity<>(accountantService.summary(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return accountantService.summary(id)
                .map(
                        v -> new ResponseEntity<>(v, HttpStatus.OK)
                ).orElseGet(
                        () -> new ResponseEntity<>(HttpStatus.NOT_FOUND)
                );
    }
}
