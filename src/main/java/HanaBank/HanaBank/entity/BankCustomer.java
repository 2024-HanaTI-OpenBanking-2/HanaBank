package HanaBank.HanaBank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "bank_customers")
public class BankCustomer {

  @Id
  @Column(name = "customer_id", nullable = false, length = 100)
  private String customerId;

  @Column(name = "password", length = 100)
  private String password;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "phone", length = 100)
  private String phone;

  @Column(name = "address", length = 256)
  private String address;

  @Column(name = "gender", length = 100)
  private String gender;

  @Column(name = "email", length = 100)
  private String email;

  @Column(name = "user_type", length = 100)
  private String userType;

  @Column(name = "registration_date")
  private Date registrationDate;

  @Column(name = "openbank_authentication_status", length = 100)
  private String openbankAuthenticationStatus;

  @Column(name = "ci", length = 255)
  private String ci;
}