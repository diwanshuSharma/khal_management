package com.management.khal_management.dtos.transaction;

import com.management.khal_management.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto extends BaseDto {
    private double totalPrice;
    private double paidAmount;
    private double pendingAmount;
    private List<TransactionItemResponseDto> transactionItems;

}
