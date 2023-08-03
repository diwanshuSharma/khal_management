package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.Item;
import com.management.khal_management.repository.ItemRepository;
import com.management.khal_management.service.contract.IItemService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

        Optional<com.management.khal_management.model.Item> itemFromModel = itemRepository.findById(itemId);
        itemRepository.deleteById(itemId);
        Item deletedItem = modelMapper.map(itemFromModel, Item.class);
        return deletedItem;
    }

    @Override
    public Item updateItem(Item itemToUpdate) {
        // create proper logic to update item

        com.management.khal_management.model.Item itemForModel = modelMapper.map(itemToUpdate, com.management.khal_management.model.Item.class);
        com.management.khal_management.model.Item updatedItem = itemRepository.save(itemForModel);
        Item updatedItemDto = modelMapper.map(updatedItem, Item.class);
        return updatedItemDto;
    }

    @Override
    public List<Item> getItems() {
        List<com.management.khal_management.model.Item> itemsFromModel = itemRepository.findAll();
        List<Item> items = modelMapper.map(itemsFromModel,  new TypeToken<List<Item>>(){}.getType());
        return items;
    }
}
