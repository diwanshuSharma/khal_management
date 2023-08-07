package com.management.khal_management.dtos.transaction;

import com.management.khal_management.dtos.BaseDto;
import com.management.khal_management.dtos.item.ItemResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionItemResponseDto extends BaseDto {
    private ItemResponseDto item;
    private Double price;
    private Double quantity;
    private Double totalAmount;
    private Double paidAmount;
    private Double pendingAmount;

}
