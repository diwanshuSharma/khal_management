package com.management.khal_management.controller;

import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionRequestDto;
import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionResponseDto;
import com.management.khal_management.service.contract.IPurchaseTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-transactions")
public class PurchaseTransactionController {

    private final IPurchaseTransactionService purchaseTransactionService;

    @Autowired
    public PurchaseTransactionController(IPurchaseTransactionService purchaseTransactionService) {
        this.purchaseTransactionService = purchaseTransactionService;
    }

    @PostMapping
    public ResponseEntity<PurchaseTransactionResponseDto> createPurchaseTransaction(
            @RequestBody PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException {
        PurchaseTransactionResponseDto createdTransaction = purchaseTransactionService.createPurchaseTransaction(requestDto);
        return ResponseEntity.ok(createdTransaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseTransactionResponseDto> getPurchaseTransactionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        PurchaseTransactionResponseDto transaction = purchaseTransactionService.getPurchaseTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseTransactionResponseDto>> getAllPurchaseTransactions() {
        List<PurchaseTransactionResponseDto> transactions = purchaseTransactionService.getAllPurchaseTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseTransactionResponseDto> updatePurchaseTransaction(
            @PathVariable Long id, @RequestBody PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException {
        PurchaseTransactionResponseDto updatedTransaction = purchaseTransactionService.updatePurchaseTransaction(id, requestDto);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseTransaction(@PathVariable Long id) {
        purchaseTransactionService.deletePurchaseTransaction(id);
        return ResponseEntity.noContent().build();
    }
}

