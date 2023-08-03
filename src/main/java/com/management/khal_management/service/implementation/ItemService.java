package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.repository.ItemRepository;
import com.management.khal_management.service.contract.IItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ItemService implements IItemService {

    private ItemRepository itemRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Item addItem(Item itemToAdd) {
        com.management.khal_management.model.Item modelItem = modelMapper.map(itemToAdd, com.management.khal_management.model.Item.class);
        com.management.khal_management.model.Item addedItem = itemRepository.save(modelItem);
        Item addedItemDto = modelMapper.map(addedItem, Item.class);
        return addedItemDto;
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
