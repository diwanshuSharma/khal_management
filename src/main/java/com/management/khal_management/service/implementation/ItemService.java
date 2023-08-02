package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.repository.ItemRepository;
import com.management.khal_management.service.contract.IItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item itemToAdd) {
        // add DTO to Model mapping here
        itemRepository.save(itemToAdd)
    }

    @Override
    public Item deleteItem(Long itemId) {
        return null;
    }

    @Override
    public Item updateItem(Item itemToUpdate) {
        return null;
    }

    @Override
    public List<Item> listItems() {
        return null;
    }
}
