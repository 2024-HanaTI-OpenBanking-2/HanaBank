package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankProduct;
import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.service.BankProductService;
import HanaBank.HanaBank.service.BankService;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankProductController {

  @Autowired
  private BankProductService bankProductService;

  @Autowired
  private BankService bankAccountService;

  @GetMapping("/productlist")
  @ResponseBody
  public List<BankProduct> productlist(@RequestParam(value = "type", required = false, defaultValue = "all") String type) {
    if ("all".equals(type)) {
      return bankProductService.getProductsByTypes(List.of("Deposit", "Investment"));
    } else if ("Deposit".equals(type)) {
      return bankProductService.getProductByProductType("Deposit");
    } else if ("Investment".equals(type)) {
      return bankProductService.getProductByProductType("Investment");
    } else {
      return List.of(); // 빈 리스트 반환
    }
  }

  @GetMapping("/productlist/all")
  public String productlistPage(Model model, HttpSession session) {
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    model.addAttribute("customer", customer);
    List<BankProduct> allProducts = bankProductService.getAllProduct();
    model.addAttribute("allProducts", allProducts);
    return "productlist";
  }

  @GetMapping("/joinproduct")
  public String joinProductPage(@RequestParam Integer productId, HttpSession session, Model model) {
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    if (customer == null) {
      return "redirect:/login";
    }
    BankProduct product = bankProductService.getProductById(productId);
    model.addAttribute("product", product);
    model.addAttribute("customer", customer);
    return "joinproduct";
  }

  @PostMapping("/joinproduct")
  public String joinProduct(@RequestParam Integer productId, @RequestParam String accountName,
      @RequestParam String accountPassword, @RequestParam String confirmPassword,
      HttpSession session, Model model) {
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    if (customer == null) {
      return "redirect:/login";
    }
    if (!accountPassword.equals(confirmPassword)) {
      model.addAttribute("error", "Passwords do not match");
      return "joinproduct";
    }

    BankProduct product = bankProductService.getProductById(productId);
    if (product == null) {
      model.addAttribute("error", "Invalid product");
      return "joinproduct";
    }

    BankAccount newAccount = new BankAccount();
    newAccount.setCustomerId(customer.getCustomerId());
    newAccount.setAccountName(accountName);
    newAccount.setCustomerPassword(accountPassword);
    newAccount.setBalance(0.0);
    newAccount.setAccountIssueDate(new Date(System.currentTimeMillis()));
    newAccount.setAccountStatus("active");
    newAccount.setBankCodeStd("4444");
    newAccount.setActivityType("Y");
    newAccount.setAccountType(product.getProductType());
    newAccount.setProductId(productId);
    newAccount.setDormancyYn("N");
    newAccount.setBalanceAmt("0");

    // Generate account number
    String accountNum = "4444" + String.format("%010d", new Random().nextInt(1000000000));
    newAccount.setAccountNum(accountNum);

    bankAccountService.saveBankAccount(newAccount);

    return "redirect:/productlist/all";
  }
}
