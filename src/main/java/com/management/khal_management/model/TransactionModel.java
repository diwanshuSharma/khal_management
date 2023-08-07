package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransactionModel extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerModel customerModel;
    private double totalPrice;
}
