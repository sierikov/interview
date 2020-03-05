package tk.artemser.task4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.artemser.task4.domain.employees.Programmer;

import java.util.UUID;

@Repository
public interface ProgrammerRepo extends CrudRepository<Programmer, UUID> {}
