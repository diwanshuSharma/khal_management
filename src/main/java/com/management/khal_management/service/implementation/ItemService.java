package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.item.ItemRequestDto;
import com.management.khal_management.dtos.item.ItemResponseDto;
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
    public ItemResponseDto addItem(ItemRequestDto itemDtoToAdd) {
        ItemModel modelItemModel = modelMapper.map(itemDtoToAdd, ItemModel.class);
        ItemModel addedItemModel = IItemRepository.save(modelItemModel);
        ItemResponseDto addedItemDtoDto = modelMapper.map(addedItemModel, ItemResponseDto.class);
        return addedItemDtoDto;
    }

    @Override
    public ItemResponseDto deleteItem(Long itemId) {

        Optional<ItemModel> itemFromModel = IItemRepository.findById(itemId);
        IItemRepository.deleteById(itemId);
        ItemResponseDto deletedItemDto = modelMapper.map(itemFromModel, ItemResponseDto.class);
        return deletedItemDto;
    }

    @Override
    public ItemResponseDto updateItem(ItemRequestDto itemDtoToUpdate) {
        ItemModel itemModelForModel = modelMapper.map(itemDtoToUpdate, ItemModel.class);
        ItemModel updatedItemModel = IItemRepository.save(itemModelForModel);
        ItemResponseDto updatedItemDtoDto = modelMapper.map(updatedItemModel, ItemResponseDto.class);
        return updatedItemDtoDto;
    }

    @Override
    public List<ItemResponseDto> getItems() {
        List<ItemModel> itemsFromModel = IItemRepository.findAll();
        List<ItemResponseDto> itemDtos = modelMapper.map(itemsFromModel,  new TypeToken<List<ItemResponseDto>>(){}.getType());
        return itemDtos;
    }

    @Override
    public ItemResponseDto getItemById(Long id) {
        ItemModel iteFromModel = IItemRepository.findById(id).get();
        ItemResponseDto itemDto = modelMapper.map(iteFromModel, ItemResponseDto.class);
        return itemDto;
    }
}
