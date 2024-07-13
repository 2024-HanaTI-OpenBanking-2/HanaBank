package HanaBank.HanaBank.service;

import HanaBank.HanaBank.entity.BankStatement;
import HanaBank.HanaBank.repository.BankStatementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  private BankStatementRepository bankStatementRepository;

  public List<BankStatement> getStatementsByAccountNum(String accountNum) {
    return bankStatementRepository.findByAccountNum(accountNum);
  }
}
