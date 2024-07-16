package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.entity.BankCustomer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/home")
  public String home(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession();
    BankCustomer customer = (BankCustomer) session.getAttribute("customer");
    if (customer == null) {
      return "redirect:/login";
    }
    model.addAttribute("customer", customer);
    return "home";
  }

}
