package HanaBank.HanaBank.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankProductDTO {

  private Integer productId;
  private String productName;
  private String productType;
  private BigDecimal interestRate;
  private Integer term;
  private BigDecimal minimumBalance;
  private String productDescription;
}
