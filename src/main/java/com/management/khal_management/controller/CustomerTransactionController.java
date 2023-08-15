package com.management.khal_management.controller;

import java.util.List;
import com.management.khal_management.dtos.transaction.TransactionRequestDto;
import com.management.khal_management.dtos.transaction.TransactionResponseDto;
import com.management.khal_management.service.contract.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer-transactions")
public class CustomerTransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto requestDto) {
        TransactionResponseDto transaction = transactionService.createTransaction(requestDto);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> getTransactionsForCustomerHavingPendingAmount(@RequestParam Long customer_id){
        List<TransactionResponseDto> response = transactionService.getAllTransactionsForCustomerHavingPendingAmount(customer_id);
        return ResponseEntity.ok(response);
    }

}
