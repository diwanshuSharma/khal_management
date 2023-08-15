package com.management.khal_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_transactions")
public class PurchaseTransactionModel extends BaseModel{

    @ManyToOne
    private SupplierModel supplier;
    @ManyToOne
    private ItemModel item;
    @ManyToOne
    private UnitModel unit;
    private double unitPrice;
    private double numberOfUnits;
    private double totalPrice;
    private double rateOfInterest;
    private double timeInterval;
    private double totalAfterInterest;
}
