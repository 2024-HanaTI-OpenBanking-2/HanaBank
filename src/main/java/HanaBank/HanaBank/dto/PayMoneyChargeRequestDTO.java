package HanaBank.HanaBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMoneyChargeRequestDTO {
    private String accountId;
    private double amount;
}