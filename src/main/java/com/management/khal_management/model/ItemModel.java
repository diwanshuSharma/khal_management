package com.management.khal_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class ItemModel extends BaseModel {

    private String itemName;
    @Column(columnDefinition = "TEXT")
    private String url;

}
