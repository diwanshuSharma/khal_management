package com.management.khal_management.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AddressModel extends BaseModel{
    private String address;
    private String village;
    private String thesil;
    private String district;
    private String state;
    private String country;
    private int pincode;

}
