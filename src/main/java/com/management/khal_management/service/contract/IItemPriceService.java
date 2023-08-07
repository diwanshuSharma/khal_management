package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.item_price.AddItemPriceRequestDto;
import com.management.khal_management.dtos.item_price.ItemPriceResponseDto;
import com.management.khal_management.dtos.item_price.UpdateItemPriceRequestDto;

import java.util.List;

public interface IItemPriceService {
    ItemPriceResponseDto createItemPrice(AddItemPriceRequestDto itemPriceDto);

    ItemPriceResponseDto updateItemPrice(UpdateItemPriceRequestDto updatedItemPriceDto);

    ItemPriceResponseDto deleteItemPrice(Long id);

    List<ItemPriceResponseDto> getAllItemPrices();

    ItemPriceResponseDto getItemPriceById(Long id);
}
