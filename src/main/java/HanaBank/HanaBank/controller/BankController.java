package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.dto.AccountCiResponseDTO;
import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.service.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountinfo")
public class BankController {

  @Autowired
  private BankService bankService;

  @PostMapping("/list")
  public ResponseEntity<List<BankAccount>> getAccountsByCi(@RequestBody AccountCiResponseDTO accountCiResponseDTO) {
    List<BankAccount> response = bankService.getAccountsByCi(accountCiResponseDTO.getCi());
    return ResponseEntity.ok(response);
  }
}