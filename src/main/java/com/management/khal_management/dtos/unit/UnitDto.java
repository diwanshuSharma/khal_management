package com.management.khal_management.dtos.unit;

import com.management.khal_management.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto extends BaseDto {
    private String name;
    private String symbol;
}
