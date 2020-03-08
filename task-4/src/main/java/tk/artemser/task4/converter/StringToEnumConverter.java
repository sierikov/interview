package tk.artemser.task4.converter;

import org.springframework.core.convert.converter.Converter;
import tk.artemser.task4.domain.employees.EmployeeType;

public class StringToEnumConverter implements Converter<String, EmployeeType> {
    @Override
    public EmployeeType convert(String source) {
        try {
            return EmployeeType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return EmployeeType.UNKNOWN;
        }
    }
}
