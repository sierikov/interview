package tk.artemser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.artemser.employees.Employee;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {
    private List<Employee> employees;
}
