package com.management.khal_management.controller;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.service.implementation.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(path = "/item/add")
    public Item addItem(@RequestBody Item itemToAdd){
        Item addedItem = itemService.addItem(itemToAdd);
        return addedItem;
    }
}
