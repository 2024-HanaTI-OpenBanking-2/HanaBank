package HanaBank.HanaBank.repository;

import HanaBank.HanaBank.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
  List<BankAccount> findByCustomerId(String customerId);
}
