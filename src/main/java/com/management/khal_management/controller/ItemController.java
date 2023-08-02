package com.management.khal_management.controller;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.service.implementation.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item addItem(Item itemToAdd){
        Item addedItem = itemService.addItem(itemToAdd);
        return addedItem;
    }
}
