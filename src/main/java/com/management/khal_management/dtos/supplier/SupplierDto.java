package com.management.khal_management.dtos.supplier;

import com.management.khal_management.dtos.BaseDto;
import com.management.khal_management.dtos.address.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto extends BaseDto {
    private String supplierName;
    private Date dob;
    private long mobileNumber;
    private AddressDto addressDto;
}
