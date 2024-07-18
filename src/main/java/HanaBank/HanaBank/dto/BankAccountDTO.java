package HanaBank.HanaBank.dto;

import java.math.BigDecimal;
import lombok.Data;

import java.sql.Date;

@Data
public class BankAccountDTO {
  private String accountNum;
  private String customerId;
  private String accountName;
  private String customerPassword;
  private Double balance; //필요 X
  private Date accountIssueDate;
  private String accountStatus; //필요 X
  private String bankCodeStd;
  private String activityType;
  private String accountType;
  private String maturityDate; //필요 X
  private Integer productId;
  private String dormancyYn;
  private String balanceAmt;
}