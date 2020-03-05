package tk.artemser.task4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.artemser.task4.domain.employees.Programmer;
import tk.artemser.task4.repository.ProgrammerRepo;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProgrammerDao {
    @Autowired
    private ProgrammerRepo programmerRepo;

    public Programmer create(Programmer programmer) {
        return programmerRepo.save(programmer);
    }

    public Optional<Programmer> read(UUID id) {
        return programmerRepo.findById(id);
    }

    public Iterable<Programmer> read(){
        return programmerRepo.findAll();
    }

    public Programmer update(Programmer programmer) {
        return programmerRepo.save(programmer);
    }

    public void delete(Programmer programmer) {
        programmerRepo.delete(programmer);
    }


}
