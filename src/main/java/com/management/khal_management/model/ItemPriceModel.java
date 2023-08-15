package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_prices")
public class ItemPriceModel extends BaseModel{
    @ManyToOne
    private ItemModel itemModel;
    private Double price;
}
