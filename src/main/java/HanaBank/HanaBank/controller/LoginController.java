package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.service.BankCustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("/checkLogin")
  @ResponseBody
  public Map<String, Boolean> checkLogin(HttpSession session) {
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    boolean loggedIn = (customer != null);
    return Collections.singletonMap("loggedIn", loggedIn);
  }
}