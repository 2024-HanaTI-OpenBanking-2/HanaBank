package HanaBank.HanaBank.service;

import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.repository.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankCustomerService {

  @Autowired
  private BankCustomerRepository BankCustomerRepository;

  public BankCustomer authenticate(String customerId, String password) {
    return BankCustomerRepository.findByCustomerIdAndPassword(customerId, password);
  }
}
