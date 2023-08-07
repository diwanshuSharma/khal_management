package com.management.khal_management.dtos.customer;

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
public class CustomerDto extends BaseDto {
    private String customerName;
    private Date dob;
    private long mobileNumber;
    private AddressDto addressDto;
}
