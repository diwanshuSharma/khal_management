package com.management.khal_management.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UnitModel extends BaseModel {
    private String name;
    private String symbol;
}
