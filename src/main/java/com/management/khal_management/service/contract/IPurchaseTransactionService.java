package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionRequestDto;
import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IPurchaseTransactionService {
    PurchaseTransactionResponseDto createPurchaseTransaction(PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException;
    PurchaseTransactionResponseDto getPurchaseTransactionById(Long id) throws ChangeSetPersister.NotFoundException;
    List<PurchaseTransactionResponseDto> getAllPurchaseTransactions();
    PurchaseTransactionResponseDto updatePurchaseTransaction(Long id, PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException;
    void deletePurchaseTransaction(Long id);
}

