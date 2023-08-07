package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.transaction.TransactionRequestDto;
import com.management.khal_management.dtos.transaction.TransactionResponseDto;

public interface ITransactionService {
    TransactionResponseDto createTransaction(TransactionRequestDto requestDto);
}
