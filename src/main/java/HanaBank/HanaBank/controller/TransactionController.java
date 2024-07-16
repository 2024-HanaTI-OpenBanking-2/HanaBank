package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.dto.AccountCiResponseDTO;
import HanaBank.HanaBank.dto.BankStatementDTO;
import HanaBank.HanaBank.dto.TransactionDTO;
import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankStatement;
import HanaBank.HanaBank.service.BankService;
import HanaBank.HanaBank.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/transaction_list")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping("/acnt_num")
  public ResponseEntity<List<BankStatement>> getStatementsByAccountNum(@RequestBody TransactionDTO transactionDTO) {
    return ResponseEntity.ok(transactionService.getStatementsByAccountNum(transactionDTO.getAccountNum()));
  }
}
