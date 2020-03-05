package tk.artemser.task4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.artemser.task4.domain.contract.Contract;
import tk.artemser.task4.domain.employees.Employee;
import tk.artemser.task4.repository.EmployeeRepo;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeDao {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Optional<Employee> read(UUID id) {
        return employeeRepo.findById(id);
    }

    public Iterable<Employee> read(){
        return employeeRepo.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void delete(Employee employee) {
        employeeRepo.delete(employee);
    }

}
