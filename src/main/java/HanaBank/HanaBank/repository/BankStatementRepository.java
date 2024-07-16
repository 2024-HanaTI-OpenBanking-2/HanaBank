package HanaBank.HanaBank.repository;

import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.entity.BankStatement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankStatementRepository extends JpaRepository<BankStatement, String> {
  List<BankStatement> findByAccountNum (String accountNum);
}
