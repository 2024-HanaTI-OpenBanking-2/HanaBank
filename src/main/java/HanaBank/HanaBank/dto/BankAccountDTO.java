package HanaBank.HanaBank.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BankAccountDTO {
  private String accountNum; // 계좌번호
//  private String customerId;
  private String accountName; // 계좌별명
//  private String customerPassword;
//  private Double balance; // 잔고
//  private Date accountIssueDate;
//  private String accountStatus;
  private String bankCodeStd; // 어느 은행인지
//  private String activityType;
//  private String accountType;
//  private String maturityDate;
  private String productName; // 상품명
//  private String dormancyYn;
  private String balanceAmt; // 계좌 잔액
}