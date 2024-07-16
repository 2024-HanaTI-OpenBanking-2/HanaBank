package HanaBank.HanaBank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_products")
@Getter
@Setter
public class BankProduct {

  @Id
  @Column(name = "product_id", nullable = false)
  private Integer productId;

  @Column(name = "product_name", nullable = false, length = 30)
  private String productName;

  @Column(name = "product_type", nullable = false, length = 10)
  private String productType;

  @Column(name = "interest_rate", nullable = false, precision = 4, scale = 2)
  private BigDecimal interestRate;

  @Column(name = "term", nullable = false)
  private Integer term;

  @Column(name = "minimum_balance", nullable = false)
  private BigDecimal minimumBalance;

  @Column(name = "product_description", length = 100)
  private String productDescription;
}
