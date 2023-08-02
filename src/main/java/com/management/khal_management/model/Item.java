package com.management.khal_management.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item extends BaseModel {

    private String itemName;
    private String url;

}
