package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankStatement;
import HanaBank.HanaBank.service.BankService;
import HanaBank.HanaBank.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/transaction_list")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/acnt_num")
  public List<BankStatement> getStatementsByAccountNum(@RequestParam String accountNum) {
    return transactionService.getStatementsByAccountNum(accountNum);
  }
}
