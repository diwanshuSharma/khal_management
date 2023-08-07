package com.management.khal_management.dtos.item;

import com.management.khal_management.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto extends BaseDto {
    private String itemName;
    private String url;
}
