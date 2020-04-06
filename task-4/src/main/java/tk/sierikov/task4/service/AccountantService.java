package tk.sierikov.task4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.sierikov.task4.dao.EmployeeDao;
import tk.sierikov.task4.domain.employees.Accountant;
import tk.sierikov.task4.response.AccountantResponse;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountantService {
    @Autowired
    private EmployeeDao employeeDao;

    public AccountantResponse summary() {
        return new AccountantResponse(Accountant.summary(
                StreamSupport.stream(
                        employeeDao.read().spliterator(), false
                ).collect(Collectors.toList())));
    }

    public Optional<AccountantResponse> summary(UUID id) {
        return employeeDao.read(id)
                .map(employee -> new AccountantResponse(employee.calculateSalary()));
    }
}
