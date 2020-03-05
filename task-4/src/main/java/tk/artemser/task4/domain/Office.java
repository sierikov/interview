package tk.artemser.task4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.artemser.task4.domain.employees.Employee;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {
    private List<Employee> employees;
}
