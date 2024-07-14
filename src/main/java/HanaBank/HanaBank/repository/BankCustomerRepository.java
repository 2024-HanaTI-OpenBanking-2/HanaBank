package HanaBank.HanaBank.repository;

import HanaBank.HanaBank.entity.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankCustomerRepository extends JpaRepository<BankCustomer, String> {
  Optional<BankCustomer> findByCi(String ci);

  BankCustomer findByCustomerIdAndPassword(String customerId, String password);
}
