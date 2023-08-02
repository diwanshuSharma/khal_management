package com.management.khal_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Customer extends BaseModel{
    private String customerName;
    private Date dob;
    private long mobileNumber;
    @OneToOne
    private Address address;
}
