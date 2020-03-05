package tk.artemser.task4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.artemser.task4.domain.employees.Manager;
import tk.artemser.task4.repository.ManagerRepo;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerDao {
    @Autowired
    private ManagerRepo managerRepo;

    public Manager create(Manager manager) {
        return managerRepo.save(manager);
    }

    public Optional<Manager> read(Long id) {
        return managerRepo.findById(id);
    }

    public Iterable<Manager> read(){
        return managerRepo.findAll();
    }

    public Manager update(Manager manager) {
        return managerRepo.save(manager);
    }

    public void delete(Manager manager) {
        managerRepo.delete(manager);
    }


}
