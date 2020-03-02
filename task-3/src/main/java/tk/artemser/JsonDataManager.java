package tk.artemser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import tk.artemser.employees.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class JsonDataManager<T extends Employee> {

    public Optional<T> read(String path){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<T> typeRef;
        typeRef = new TypeReference<T>() {};
        try {
            return Optional.of(mapper.readValue(new File(path), typeRef));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public boolean write(T employee, String path){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(path), employee);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
