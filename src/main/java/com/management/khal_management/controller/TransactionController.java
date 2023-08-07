package com.management.khal_management.controller;

import com.management.khal_management.dtos.transaction.TransactionRequestDto;
import com.management.khal_management.dtos.transaction.TransactionResponseDto;
import com.management.khal_management.service.implementation.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto requestDto) {
        TransactionResponseDto transaction = transactionService.createTransaction(requestDto);
        return ResponseEntity.ok(transaction);
    }

}
