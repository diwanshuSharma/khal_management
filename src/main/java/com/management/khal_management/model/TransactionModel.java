package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionModel extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerModel customerModel;
    private double totalPrice;
}
