package com.management.khal_management.dtos.item_price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemPriceRequestDto {
    private Long itemId;
    private Double price;
}
