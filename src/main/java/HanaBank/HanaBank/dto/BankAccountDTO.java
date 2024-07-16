package HanaBank.HanaBank.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BankAccountDTO {
  private String accountNum;
  private String customerId;
  private String accountName;
  private String customerPassword;
  private Double balance;
  private Date accountIssueDate;
  private String accountStatus;
  private String bankCodeStd;
  private String activityType;
  private String accountType;
  private String maturityDate;
  private String productName;
  private String dormancyYn;
  private String balanceAmt;
}