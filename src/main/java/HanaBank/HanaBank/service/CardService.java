package HanaBank.HanaBank.service;

import HanaBank.HanaBank.dto.PayMoneyChargeRequestDTO;
import HanaBank.HanaBank.dto.PayMoneyChargeResponseDTO;
import HanaBank.HanaBank.entity.BankAccount;
import HanaBank.HanaBank.repository.BankAccountRepository;
import HanaBank.HanaBank.repository.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardService {
    @Autowired
    private BankCustomerRepository bankCustomerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;


    @Transactional
    public PayMoneyChargeResponseDTO chargeAccount(PayMoneyChargeRequestDTO request) {
        BankAccount account = bankAccountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + request.getAccountId()));

        // 금액이 부족하면 에러 발생
        if (account.getBalance() < request.getAmount()) {
            throw new RuntimeException("Insufficient funds for transaction");
        }

        // 차감 처리
        account.setBalance(account.getBalance() - request.getAmount());
        bankAccountRepository.save(account);

        // 응답 DTO 생성
        PayMoneyChargeResponseDTO response = new PayMoneyChargeResponseDTO(
                account.getBankCodeStd(),
                String.valueOf(account.getBalance()),
                request.getAmount(),
                account.getAccountNum()
        );
        System.out.println(response);
        return response;
    }
}
