package com.management.khal_management.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemQuantityRequestDto {
    private Long item_id;
    private Double quantity;
}
