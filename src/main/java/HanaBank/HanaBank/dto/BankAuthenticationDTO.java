package HanaBank.HanaBank.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BankAuthenticationDTO {
  private String accessTokenId;
  private Integer expiresIn;
  private String refreshToken;
  private String authScope;
  private Timestamp createdAt;
  private Timestamp updatedAt;
  private String clientUseCode;
}
