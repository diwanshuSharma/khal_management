package com.management.khal_management.controller;

import com.management.khal_management.service.contract.ICustomerTransactionSettlementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer-transaction-amount-settle-up")
public class CustomerTransactionAmountSettleUpController {

    private final ICustomerTransactionSettlementService customerTransactionSettlement;

    public CustomerTransactionAmountSettleUpController(ICustomerTransactionSettlementService customerTransactionSettlement) {
        this.customerTransactionSettlement = customerTransactionSettlement;
    }

    @GetMapping
    public ResponseEntity<Void> deletePurchaseTransaction(@RequestParam Long customer_id, @RequestParam Double amount) {
        customerTransactionSettlement.SettleUpGivenAmount(customer_id, amount);
        return ResponseEntity.noContent().build();
    }
}
