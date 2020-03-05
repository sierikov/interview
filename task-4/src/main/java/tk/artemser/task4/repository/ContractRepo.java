package tk.artemser.task4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.artemser.task4.domain.contract.Contract;

import java.util.UUID;

@Repository
public interface ContractRepo extends CrudRepository<Contract, UUID> {}
