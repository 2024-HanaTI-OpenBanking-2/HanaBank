package HanaBank.HanaBank.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BankCustomerDTO {
  private String customerId;
  private String password;
  private String name;
  private String phone;
  private String address;
  private String gender;
  private String email;
  private String userType;
  private Date registrationDate;
  private String openbankAuthenticationStatus;
  private String ci;
}