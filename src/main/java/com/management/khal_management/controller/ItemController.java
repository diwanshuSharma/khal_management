package com.management.khal_management.controller;

import com.management.khal_management.dtos.ItemDto;
import com.management.khal_management.service.contract.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {

    private final IItemService itemService;

    @Autowired
    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDto addItem(@RequestBody ItemDto itemDtoToAdd){
        ItemDto addedItemDto = itemService.addItem(itemDtoToAdd);
        return addedItemDto;
    }

    @GetMapping
    public List<ItemDto> getItems(){
        List<ItemDto> itemDtos = itemService.getItems();
        return itemDtos;
    }

    @GetMapping("/{id}")
    public ItemDto getCustomerById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public ItemDto getItems(@PathVariable Long id){
        ItemDto deletedItemDto = itemService.deleteItem(id);
        return deletedItemDto;
    }

    @PutMapping
    public ItemDto updateItem(@RequestBody ItemDto itemDtoToUpdate){
        ItemDto updatedItemDto = itemService.updateItem(itemDtoToUpdate);
        return updatedItemDto;
    }
}
