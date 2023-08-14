package com.management.khal_management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseTransactionModel extends BaseModel{

    private SupplierModel supplier;
    private ItemModel item;
    private UnitModel unit;
    private double unitPrice;
    private double numberOfUnits;
    private double totalPrice;
    private double rateOfInterest;
    private double timeInterval;
    private double totalAfterInterest;
}
