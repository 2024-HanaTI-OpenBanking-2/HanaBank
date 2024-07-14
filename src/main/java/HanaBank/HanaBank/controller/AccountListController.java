package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.service.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountinfo")
public class AccountListController {
  @Autowired
  private BankService bankService;

  @GetMapping("/list")
  public List<BankAccount> getAccountsByCi(@RequestParam String ci) {
    return bankService.getAccountsByCi(ci);
  }
}
