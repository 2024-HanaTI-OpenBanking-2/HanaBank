package HanaBank.HanaBank.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "bank_authentications")
public class BankAuthentication {

  @Id
  @Column(name = "access_token_id", nullable = false, length = 255)
  private String accessTokenId;

  @Column(name = "expires_in")
  private Integer expiresIn;

  @Column(name = "refresh_token", length = 255)
  private String refreshToken;

  @Column(name = "auth_scope", length = 255)
  private String authScope;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @Column(name = "client_use_code", length = 255)
  private String clientUseCode;
}