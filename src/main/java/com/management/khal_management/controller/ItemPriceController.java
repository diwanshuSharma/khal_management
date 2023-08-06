package com.management.khal_management.controller;
import com.management.khal_management.dtos.ItemPriceDto;
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
    public ItemPriceDto createItemPrice(@RequestBody ItemPriceDto itemPrice) {
        ItemPriceDto createdItemPrice = itemPriceService.createItemPrice(itemPrice);
        return createdItemPrice;
    }

    @PutMapping("/{id}")
    public ItemPriceDto updateItemPrice(@RequestBody ItemPriceDto updatedItemPrice) {
        ItemPriceDto updatedPrice = itemPriceService.updateItemPrice(updatedItemPrice);
        return updatedPrice;
    }

    @DeleteMapping("/{id}")
    public ItemPriceDto deleteItemPrice(@PathVariable Long id) {
        ItemPriceDto itemPrice = itemPriceService.deleteItemPrice(id);
        return itemPrice;
    }

    @GetMapping
    public List<ItemPriceDto> getAllItemPrices() {
        List<ItemPriceDto> itemPrices = itemPriceService.getAllItemPrices();
        return itemPrices;
    }

    @GetMapping("/{id}")
    public ItemPriceDto getItemPriceById(@PathVariable Long id) {
        ItemPriceDto itemPrice = itemPriceService.getItemPriceById(id);
        return itemPrice;
    }
}
