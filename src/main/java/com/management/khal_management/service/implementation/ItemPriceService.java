package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.item_price.AddItemPriceRequestDto;
import com.management.khal_management.dtos.item_price.ItemPriceResponseDto;
import com.management.khal_management.dtos.item_price.UpdateItemPriceRequestDto;
import com.management.khal_management.model.ItemModel;
import com.management.khal_management.model.ItemPriceModel;
import com.management.khal_management.repository.IItemPriceRepository;
import com.management.khal_management.repository.IItemRepository;
import com.management.khal_management.service.contract.IItemPriceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPriceService implements IItemPriceService {
    private final IItemPriceRepository itemPriceRepository;
    private final IItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemPriceService(IItemPriceRepository itemPriceRepository, IItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemPriceRepository = itemPriceRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public ItemPriceResponseDto createItemPrice(AddItemPriceRequestDto itemPriceDto) {
        ItemModel item = itemRepository.findById(itemPriceDto.getItemId()).get();

        ItemPriceModel itemPriceModel = new ItemPriceModel();
        itemPriceModel.setItemModel(item);
        itemPriceModel.setPrice(itemPriceDto.getPrice());
        itemPriceModel = itemPriceRepository.save(itemPriceModel);

        ItemPriceResponseDto itemPrice = modelMapper.map(itemPriceModel, ItemPriceResponseDto.class);
        return itemPrice;
    }

    @Transactional
    @Override
    public ItemPriceResponseDto updateItemPrice(UpdateItemPriceRequestDto updatedItemPriceDto) {
        ItemPriceModel existingItemPrice = itemPriceRepository.findById(updatedItemPriceDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));

        existingItemPrice.setPrice(updatedItemPriceDto.getPrice());

        existingItemPrice = itemPriceRepository.save(existingItemPrice);
        ItemPriceResponseDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceResponseDto.class);
        return  itemPrice;
    }

    @Transactional
    @Override
    public ItemPriceResponseDto deleteItemPrice(Long id) {
        ItemPriceModel existingItemPrice = itemPriceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));

        itemPriceRepository.delete(existingItemPrice);
        ItemPriceResponseDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceResponseDto.class);
        return  itemPrice;
    }

    @Override
    public List<ItemPriceResponseDto> getAllItemPrices() {
        List<ItemPriceModel> itemPrices = itemPriceRepository.findAll();
        List<ItemPriceResponseDto> itemPricesDto = modelMapper.map(itemPrices,  new TypeToken<List<ItemPriceResponseDto>>(){}.getType());
        return itemPricesDto;
    }

    @Override
    public ItemPriceResponseDto getItemPriceById(Long id) {
        ItemPriceModel  existingItemPrice = itemPriceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));
        ItemPriceResponseDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceResponseDto.class);
        return  itemPrice;
    }
}
