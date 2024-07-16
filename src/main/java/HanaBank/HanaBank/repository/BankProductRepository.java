package HanaBank.HanaBank.repository;

import HanaBank.HanaBank.entity.BankProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankProductRepository extends JpaRepository<BankProduct, Integer> {
  List<BankProduct> findByProductType(String productType);
  List<BankProduct> findByProductTypeIn(List<String> productTypes);

  BankProduct findByProductId(Integer productId);
}
