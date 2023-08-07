package com.management.khal_management.dtos.address;

import com.management.khal_management.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto extends BaseDto {
    private String address;
    private String village;
    private String thesil;
    private String district;
    private String state;
    private String country;
    private int pincode;
}
