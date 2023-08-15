package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.transaction.TransactionRequestDto;
import com.management.khal_management.dtos.transaction.TransactionResponseDto;

import java.util.List;

public interface ITransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto requestDto);

    List<TransactionResponseDto> getAllTransactionsForCustomerHavingPendingAmount(Long customer_id);
}
