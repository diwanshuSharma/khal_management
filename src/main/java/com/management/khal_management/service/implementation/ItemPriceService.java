package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.ItemPriceDto;
import com.management.khal_management.model.ItemPriceModel;
import com.management.khal_management.repository.IItemPriceRepository;
import com.management.khal_management.service.contract.IItemPriceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemPriceService implements IItemPriceService {
    private final IItemPriceRepository IItemPriceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemPriceService(IItemPriceRepository IItemPriceRepository, ModelMapper modelMapper) {
        this.IItemPriceRepository = IItemPriceRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public ItemPriceDto createItemPrice(ItemPriceDto itemPriceDto) {
        ItemPriceModel itemPriceModel = modelMapper.map(itemPriceDto, ItemPriceModel.class);
        itemPriceModel = IItemPriceRepository.save(itemPriceModel);
        ItemPriceDto itemPrice = modelMapper.map(itemPriceModel, ItemPriceDto.class);
        return itemPrice;
    }

    @Transactional
    @Override
    public ItemPriceDto updateItemPrice(ItemPriceDto updatedItemPriceDto) {
        ItemPriceModel existingItemPrice = IItemPriceRepository.findById(updatedItemPriceDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));

        existingItemPrice.setPrice(updatedItemPriceDto.getPrice());

        existingItemPrice = IItemPriceRepository.save(existingItemPrice);
        ItemPriceDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceDto.class);
        return  itemPrice;
    }

    @Transactional
    @Override
    public ItemPriceDto deleteItemPrice(Long id) {
        ItemPriceModel existingItemPrice = IItemPriceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));

        IItemPriceRepository.delete(existingItemPrice);
        ItemPriceDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceDto.class);
        return  itemPrice;
    }

    @Override
    public List<ItemPriceDto> getAllItemPrices() {
        List<ItemPriceModel> itemPrices = IItemPriceRepository.findAll();
        List<ItemPriceDto> itemPricesDto = modelMapper.map(itemPrices,  new TypeToken<List<ItemPriceDto>>(){}.getType());
        return itemPricesDto;
    }

    @Override
    public ItemPriceDto getItemPriceById(Long id) {
        ItemPriceModel  existingItemPrice = IItemPriceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ItemPriceDto not found"));
        ItemPriceDto itemPrice = modelMapper.map(existingItemPrice, ItemPriceDto.class);
        return  itemPrice;
    }
}
