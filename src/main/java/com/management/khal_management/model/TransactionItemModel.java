package com.management.khal_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransactionItemModel extends BaseModel{

    @ManyToOne(cascade = CascadeType.ALL)
    private TransactionModel transactionModel;
    @ManyToOne
    private ItemModel itemModel;
    private Double price;
    private Double quantity;
    private Double totalAmount;
    private Double paidAmount;
    private Double pendingAmount;
}
