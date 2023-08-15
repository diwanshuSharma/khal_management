package com.management.khal_management.dtos.purchase_transaction;

import com.management.khal_management.dtos.BaseDto;
import com.management.khal_management.model.ItemModel;
import com.management.khal_management.model.SupplierModel;
import com.management.khal_management.model.UnitModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTransactionRequestDto extends BaseDto {
    private Long supplierId;
    private Long itemId;
    private Long unitId;
    private double unitPrice;
    private double numberOfUnits;
    private double rateOfInterest;
    private double timeInterval;
}
