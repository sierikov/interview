package tk.artemser.task4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.artemser.task4.domain.contract.Contract;
import tk.artemser.task4.repository.ContractRepo;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContractDao {
    @Autowired
    private ContractRepo contractRepo;

    public Optional<Contract> read(UUID id) {
        return contractRepo.findById(id);
    }

    public Iterable<Contract> read(){
        return contractRepo.findAll();
    }

    public Contract update(Contract contract) {
        return contractRepo.save(contract);
    }
}
