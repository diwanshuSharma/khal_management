package com.management.khal_management.dtos.item_price;

import com.management.khal_management.dtos.BaseDto;
import com.management.khal_management.model.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPriceResponseDto extends BaseDto {
    private ItemModel itemModel;
    private Double price;
}
