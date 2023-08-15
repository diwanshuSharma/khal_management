package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "units")
public class UnitModel extends BaseModel {
    private String name;
    private String symbol;
}
