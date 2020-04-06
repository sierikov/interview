package tk.sierikov.task4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.sierikov.task4.domain.employees.Employee;
import tk.sierikov.task4.domain.employees.EmployeeType;

import java.util.UUID;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, UUID> {
    Iterable<Employee> findAllByType(EmployeeType type);

}
