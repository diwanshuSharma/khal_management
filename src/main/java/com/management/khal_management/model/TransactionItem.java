package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TransactionItem extends BaseModel{

    @ManyToOne
    private Transaction transaction;
    @ManyToOne
    private Item item;
    private Double price;
    private Double quantity;
    private Double total;
}
