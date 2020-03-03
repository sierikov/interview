package tk.artemser;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import tk.artemser.employees.Employee;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public class JsonDataManager {

    public Optional<List<Employee>> read(String path){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Office office = mapper.readValue(new File(path), new TypeReference<Office>(){});
            return Optional.of(office.getEmployees());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public boolean write(List<Employee> employees, String path){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(path), new Office(employees));
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
