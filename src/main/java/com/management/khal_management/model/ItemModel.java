package com.management.khal_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemModel extends BaseModel {

    private String itemName;
    @Column(columnDefinition = "TEXT")
    private String url;

}
