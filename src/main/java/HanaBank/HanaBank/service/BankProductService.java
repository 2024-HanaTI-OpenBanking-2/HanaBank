package HanaBank.HanaBank.service;

import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.entity.BankCustomer;
import HanaBank.HanaBank.entity.BankProduct;
import HanaBank.HanaBank.repository.BankAccountRepository;
import HanaBank.HanaBank.repository.BankProductRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankProductService {

  @Autowired
  private BankProductRepository bankProductRepository;

  @Autowired
  private BankAccountRepository bankAccountRepository;

  public List<BankProduct> getProductByProductType(String productType) {
    return bankProductRepository.findByProductType(productType);
  }

  public List<BankProduct> getProductsByTypes(List<String> productTypes) {
    return bankProductRepository.findByProductTypeIn(productTypes);
  }

  public BankProduct getProductById(Integer productId) {
    return bankProductRepository.findByProductId(productId);
  }
  public List<BankProduct> getAllProduct() {
    return bankProductRepository.findAll();
  }

  public void joinProduct(BankCustomer customer, Integer productId, String accountName, String accountPassword) {
    BankProduct product = getProductById(productId);
    if (product != null) {
      BankAccount newAccount = new BankAccount();
      newAccount.setCustomerId(customer.getCustomerId());
      newAccount.setAccountName(accountName);
      newAccount.setCustomerPassword(accountPassword);
      newAccount.setBalance((double) 0); // 초기 잔액은 0으로 설정
      newAccount.setAccountType(product.getProductType());
      newAccount.setProductId(product.getProductId());
      // 기타 초기화 로직 추가 가능
      bankAccountRepository.save(newAccount);
    }
  }
}
