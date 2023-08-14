package com.management.khal_management.controller;
import com.management.khal_management.dtos.item_price.AddItemPriceRequestDto;
import com.management.khal_management.dtos.item_price.ItemPriceResponseDto;
import com.management.khal_management.dtos.item_price.UpdateItemPriceRequestDto;
import com.management.khal_management.service.contract.IItemPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-prices")
public class ItemPriceController {

    private final IItemPriceService itemPriceService;

    @Autowired
    public ItemPriceController(IItemPriceService itemPriceService) {
        this.itemPriceService = itemPriceService;
    }

    @PostMapping
    public ItemPriceResponseDto createItemPrice(@RequestBody AddItemPriceRequestDto itemPrice) {
        ItemPriceResponseDto createdItemPrice = itemPriceService.createItemPrice(itemPrice);
        return createdItemPrice;
    }

    @PutMapping
    public ItemPriceResponseDto updateItemPrice(@RequestBody UpdateItemPriceRequestDto updatedItemPrice) {
        ItemPriceResponseDto updatedPrice = itemPriceService.updateItemPrice(updatedItemPrice);
        return updatedPrice;
    }

    @DeleteMapping("/{id}")
    public ItemPriceResponseDto deleteItemPrice(@PathVariable Long id) {
        ItemPriceResponseDto itemPrice = itemPriceService.deleteItemPrice(id);
        return itemPrice;
    }

    @GetMapping
    public List<ItemPriceResponseDto> getAllItemPrices() {
        List<ItemPriceResponseDto> itemPrices = itemPriceService.getAllItemPrices();
        return itemPrices;
    }

    @GetMapping("/{id}")
    public ItemPriceResponseDto getItemPriceById(@PathVariable Long id) {
        ItemPriceResponseDto itemPrice = itemPriceService.getItemPriceById(id);
        return itemPrice;
    }
}
