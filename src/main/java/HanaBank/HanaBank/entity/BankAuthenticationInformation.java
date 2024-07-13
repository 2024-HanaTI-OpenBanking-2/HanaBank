package HanaBank.HanaBank.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bank_authentication_informations")
public class BankAuthenticationInformation {

  @Id
  @Column(name = "client_id", nullable = false, length = 100)
  private String clientId;

  @Column(name = "client_secret", length = 100)
  private String clientSecret;

  @Column(name = "client_name", length = 100)
  private String clientName;
}

