package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.service.BankService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

  @Autowired
  private BankService bankService;

  @GetMapping("/myaccount")
  public String myaccountPage(HttpSession session, Model model) {
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    if (customer != null) {
      String customerId = customer.getCustomerId();
      List<BankAccount> accounts = bankService.getAccountsByCustomerId(customerId);
      // 입출금 계좌 필터링 및 계산
//      System.out.println(accounts);
      List<BankAccount> depositWithdrawAccounts = filterAccountsByType(accounts, "checking");
//      System.out.println(depositWithdrawAccounts);
      int depositWithdrawCount = countAccounts(depositWithdrawAccounts);
      double depositWithdrawBalanceSum = sumAccountBalances(depositWithdrawAccounts);

      // 예적금 계좌 필터링 및 계산
      List<BankAccount> savingsAccounts = filterAccountsByType(accounts, "savings");
      int savingsCount = countAccounts(savingsAccounts);
      double savingsBalanceSum = sumAccountBalances(savingsAccounts);

      model.addAttribute("depositWithdrawAccounts", depositWithdrawAccounts);
      model.addAttribute("depositWithdrawCount", depositWithdrawCount);
      model.addAttribute("depositWithdrawBalanceSum", depositWithdrawBalanceSum);
      model.addAttribute("savingsAccounts", savingsAccounts);
      model.addAttribute("savingsCount", savingsCount);
      model.addAttribute("savingsBalanceSum", savingsBalanceSum);
      return "accountinfo";
    } else {
      return "redirect:/login?error=true";
    }
  }

  private List<BankAccount> filterAccountsByType(List<BankAccount> accounts, String accountType) {
    return accounts.stream()
        .filter(account -> accountType.equals(account.getAccountType()))
        .collect(Collectors.toList());
  }

  private int countAccounts(List<BankAccount> accounts) {
    return accounts.size();
  }

  private double sumAccountBalances(List<BankAccount> accounts) {
    return accounts.stream()
        .mapToDouble(BankAccount::getBalance)
        .sum();
  }
}