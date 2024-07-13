package HanaBank.HanaBank.service;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.repository.BankAccountRepository;
import HanaBank.HanaBank.repository.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

  @Autowired
  private BankCustomerRepository bankCustomerRepository;

  @Autowired
  private BankAccountRepository bankAccountRepository;

  public List<BankAccount> getAccountsByCi(String ci) {
    Optional<BankCustomer> customerOpt = bankCustomerRepository.findByCi(ci);
    if (customerOpt.isPresent()) {
      BankCustomer customer = customerOpt.get();
      return bankAccountRepository.findByCustomerId(customer.getCustomerId());
    }
    return List.of();
  }
}
