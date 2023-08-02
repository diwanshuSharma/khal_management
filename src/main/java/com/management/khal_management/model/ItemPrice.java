package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemPrice extends BaseModel{
    @ManyToOne
    private Item item;
    private Double price;
}
