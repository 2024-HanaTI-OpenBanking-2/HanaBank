package HanaBank.HanaBank.controller;

import HanaBank.HanaBank.dto.PayMoneyChargeRequestDTO;
import HanaBank.HanaBank.dto.PayMoneyChargeResponseDTO;
import HanaBank.HanaBank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/paymoney-charge")
    private ResponseEntity<PayMoneyChargeResponseDTO> getPaymentChargeResponse(
            @RequestBody PayMoneyChargeRequestDTO payloadChargeRequestDTO
            ){
        PayMoneyChargeResponseDTO payChargeResponseDTO = cardService.chargeAccount(payloadChargeRequestDTO);
        return ResponseEntity.ok(payChargeResponseDTO);
    }

}
