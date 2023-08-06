package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.ItemPriceDto;

import java.util.List;

public interface IItemPriceService {
    ItemPriceDto createItemPrice(ItemPriceDto itemPriceDto);

    ItemPriceDto updateItemPrice(ItemPriceDto updatedItemPriceDto);

    ItemPriceDto deleteItemPrice(Long id);

    List<ItemPriceDto> getAllItemPrices();

    ItemPriceDto getItemPriceById(Long id);
}
