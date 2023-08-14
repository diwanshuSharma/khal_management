package com.management.khal_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class SupplierModel extends BaseModel {
    private String supplierName;
    private Date dob;
    private long mobileNumber;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressModel addressModel;
}

