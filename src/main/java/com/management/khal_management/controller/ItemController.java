package com.management.khal_management.controller;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.service.implementation.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/items")
    public List<Item> getItems(){
        List<Item> items = itemService.getItems();
        return items;
    }

    @DeleteMapping(path = "/item/delete")
    public Item getItems(@RequestParam("id") Long itemId){
        Item deletedItem = itemService.deleteItem(itemId);
        return deletedItem;
    }

    @PutMapping(path = "/item/update")
    public Item updateItem(@RequestBody Item itemToUpdate){
        Item updatedItem = itemService.updateItem(itemToUpdate);
        return updatedItem;
    }
}
