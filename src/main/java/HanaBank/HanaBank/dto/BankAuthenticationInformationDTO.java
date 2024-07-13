package HanaBank.HanaBank.dto;


import lombok.Data;

@Data
public class BankAuthenticationInformationDTO {

  private String clientId;
  private String clientSecret;
  private String clientName;
}