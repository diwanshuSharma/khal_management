package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.ItemDto;

import java.util.List;

public interface IItemService {
    ItemDto addItem(ItemDto itemDtoToAdd);
    ItemDto deleteItem(Long itemId);
    ItemDto updateItem(ItemDto itemDtoToUpdate);
    List<ItemDto> getItems();
    ItemDto getItemById(Long id);
}
