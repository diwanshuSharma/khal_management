package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.item.ItemRequestDto;
import com.management.khal_management.dtos.item.ItemResponseDto;

import java.util.List;

public interface IItemService {
    ItemResponseDto addItem(ItemRequestDto itemDtoToAdd);
    ItemResponseDto deleteItem(Long itemId);
    ItemResponseDto updateItem(ItemRequestDto itemDtoToUpdate);
    List<ItemResponseDto> getItems();
    ItemResponseDto getItemById(Long id);
}
