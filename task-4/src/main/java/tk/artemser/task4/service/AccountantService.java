package tk.artemser.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.artemser.task4.dao.EmployeeDao;
import tk.artemser.task4.domain.employees.Accountant;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountantService {
    @Autowired
    private EmployeeDao employeeDao;

    public Double summary(){
        return Accountant.summary(
                StreamSupport.stream(
                        employeeDao.read().spliterator(), false
                ).collect(Collectors.toList()));
    }
}
