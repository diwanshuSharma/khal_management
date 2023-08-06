package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.ItemDto;
import com.management.khal_management.model.ItemModel;
import com.management.khal_management.repository.IItemRepository;
import com.management.khal_management.service.contract.IItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    private IItemRepository IItemRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ItemService(IItemRepository IItemRepository, ModelMapper modelMapper) {
        this.IItemRepository = IItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ItemDto addItem(ItemDto itemDtoToAdd) {
        ItemModel modelItemModel = modelMapper.map(itemDtoToAdd, ItemModel.class);
        ItemModel addedItemModel = IItemRepository.save(modelItemModel);
        ItemDto addedItemDtoDto = modelMapper.map(addedItemModel, ItemDto.class);
        return addedItemDtoDto;
    }

    @Override
    public ItemDto deleteItem(Long itemId) {

        Optional<ItemModel> itemFromModel = IItemRepository.findById(itemId);
        IItemRepository.deleteById(itemId);
        ItemDto deletedItemDto = modelMapper.map(itemFromModel, ItemDto.class);
        return deletedItemDto;
    }

    @Override
    public ItemDto updateItem(ItemDto itemDtoToUpdate) {
        ItemModel itemModelForModel = modelMapper.map(itemDtoToUpdate, ItemModel.class);
        ItemModel updatedItemModel = IItemRepository.save(itemModelForModel);
        ItemDto updatedItemDtoDto = modelMapper.map(updatedItemModel, ItemDto.class);
        return updatedItemDtoDto;
    }

    @Override
    public List<ItemDto> getItems() {
        List<ItemModel> itemsFromModel = IItemRepository.findAll();
        List<ItemDto> itemDtos = modelMapper.map(itemsFromModel,  new TypeToken<List<ItemDto>>(){}.getType());
        return itemDtos;
    }

    @Override
    public ItemDto getItemById(Long id) {
        ItemModel iteFromModel = IItemRepository.findById(id).get();
        ItemDto itemDto = modelMapper.map(iteFromModel, ItemDto.class);
        return itemDto;
    }
}
