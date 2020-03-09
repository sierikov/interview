package tk.artemser.task4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
public class AccountantResponse {
    private Double salary;

    @Generated
    public Double getSalary(){
        return BigDecimal.valueOf(this.salary)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
