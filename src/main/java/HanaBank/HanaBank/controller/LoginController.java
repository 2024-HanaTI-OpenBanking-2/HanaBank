package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.service.BankCustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  private BankCustomerService BankCustomerService;
  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String login(String customerId, String password, HttpServletRequest request, Model model) {
    BankCustomer customer = BankCustomerService.authenticate(customerId, password);
    if (customer != null) {
      HttpSession session = request.getSession();
      session.setAttribute("customer", customer);
      return "redirect:/home";
    } else {
      model.addAttribute("error", "Invalid username or password.");
      return "login";
    }
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/login";
  }
}
