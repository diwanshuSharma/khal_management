package com.management.khal_management.service.contract;

import com.management.khal_management.dtos.Item;

import java.util.List;

public interface IItemService {
    Item addItem(Item itemToAdd);
    Item deleteItem(Long itemId);
    Item updateItem(Item itemToUpdate);
    List<Item> getItems();
}
