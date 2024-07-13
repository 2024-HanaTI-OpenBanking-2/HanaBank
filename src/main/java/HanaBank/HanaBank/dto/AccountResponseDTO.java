package HanaBank.HanaBank.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDTO {
  private int ci;
  private String name;
}
