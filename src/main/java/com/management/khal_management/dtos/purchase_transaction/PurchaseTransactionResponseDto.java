package com.management.khal_management.dtos.purchase_transaction;

import com.management.khal_management.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTransactionResponseDto extends BaseDto {
    private Long supplierId;
    private Long itemId;
    private Long unitId;
    private double unitPrice;
    private double numberOfUnits;
    private double totalPrice;
    private double rateOfInterest;
    private double timeInterval;
    private double totalAfterInterest;
}
