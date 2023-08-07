package com.management.khal_management.controller;

import com.management.khal_management.dtos.item.ItemRequestDto;
import com.management.khal_management.dtos.item.ItemResponseDto;
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
    public ItemResponseDto addItem(@RequestBody ItemRequestDto itemDtoToAdd){
        ItemResponseDto addedItemDto = itemService.addItem(itemDtoToAdd);
        return addedItemDto;
    }

    @GetMapping
    public List<ItemResponseDto> getItems(){
        List<ItemResponseDto> itemDtos = itemService.getItems();
        return itemDtos;
    }

    @GetMapping("/{id}")
    public ItemResponseDto getCustomerById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public ItemResponseDto getItems(@PathVariable Long id){
        ItemResponseDto deletedItemDto = itemService.deleteItem(id);
        return deletedItemDto;
    }

    @PutMapping
    public ItemResponseDto updateItem(@RequestBody ItemRequestDto itemDtoToUpdate){
        ItemResponseDto updatedItemDto = itemService.updateItem(itemDtoToUpdate);
        return updatedItemDto;
    }
}
