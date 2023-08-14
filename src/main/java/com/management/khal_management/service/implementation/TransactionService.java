package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.transaction.ItemQuantityRequestDto;
import com.management.khal_management.dtos.transaction.TransactionItemResponseDto;
import com.management.khal_management.dtos.transaction.TransactionRequestDto;
import com.management.khal_management.dtos.transaction.TransactionResponseDto;
import com.management.khal_management.model.*;
import com.management.khal_management.repository.*;
import com.management.khal_management.service.contract.ITransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final ITransactionRepository transactionRepository;
    private final IItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final IItemPriceRepository itemPriceRepository;
    private final ITransactionItemRepository transactionItemRepository;
    private final ICustomerRepository customerRepository;

    @Autowired
    public TransactionService(ITransactionRepository transactionRepository, IItemRepository itemRepository, ModelMapper modelMapper, IItemPriceRepository itemPriceRepository, ITransactionItemRepository transactionItemRepository, ICustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.itemPriceRepository = itemPriceRepository;
        this.transactionItemRepository = transactionItemRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public TransactionResponseDto createTransaction(TransactionRequestDto requestDto) {
        TransactionModel transaction = new TransactionModel();
        TransactionItemModel transactionItem;
        double totalPrice = 0;
        double itemLevelTotal = 0;
        double paidAmount = 0;
        double pendingAmount = 0;
        double moneyProvided = requestDto.getMoneyProvided();

        //set customer
        CustomerModel customer = customerRepository.findById(requestDto.getCustomer_id()).get();
        transaction.setCustomerModel(customer);

        // Populate and save TransactionItemModel instances
        List<TransactionItemModel> transactionItems = new ArrayList<>();
        for (ItemQuantityRequestDto itemDto : requestDto.getItems()) {
            ItemModel item = itemRepository.findById(itemDto.getItem_id()).get();
            ItemPriceModel itemPrice = itemPriceRepository.findById(item.getId()).
                    stream().sorted(Comparator.comparing(BaseModel::getCreatedAt)).
                    findFirst().get();

            itemLevelTotal =  itemDto.getQuantity() * itemPrice.getPrice();
            if(itemLevelTotal <= moneyProvided){
                paidAmount = itemLevelTotal;
                pendingAmount = 0;
            }
            else{
                paidAmount = moneyProvided;
                pendingAmount = itemLevelTotal - paidAmount;
            }
            moneyProvided -= paidAmount;

            // create model object
            transactionItem = new TransactionItemModel();
            transactionItem.setItemModel(item);
            transactionItem.setQuantity(itemDto.getQuantity());
            transactionItem.setPrice(itemPrice.getPrice());
            transactionItem.setPaidAmount(paidAmount);
            transactionItem.setPendingAmount(pendingAmount);
            transactionItem.setTotalAmount(itemLevelTotal);

            transactionItems.add(transactionItem);

            totalPrice += itemLevelTotal;
        }

        transaction.setTotalPrice(totalPrice);


        // Save the transaction and its items
        List<TransactionItemModel> savedTransaction = transactionItemRepository.saveAll(transactionItems);

        // Convert savedTransaction to TransactionResponseDto
        TransactionResponseDto responseDto = getTransactionResponseDto(savedTransaction);

        return responseDto;

    }

    private TransactionResponseDto getTransactionResponseDto(List<TransactionItemModel> savedTransaction) {
        double pendingAmount;
        double paidAmount;
        double totalPrice;
        TransactionResponseDto responseDto = new TransactionResponseDto();
        List<TransactionItemResponseDto> transactionItemsDto = new ArrayList<>();
        TransactionItemResponseDto transactionItemResponseDto = null;
        totalPrice = 0;
        pendingAmount = 0;
        paidAmount = 0;

        for(TransactionItemModel savedTransactionItem : savedTransaction){
            transactionItemResponseDto = modelMapper.map(savedTransactionItem, TransactionItemResponseDto.class);
            transactionItemsDto.add(transactionItemResponseDto);

            paidAmount += savedTransactionItem.getPaidAmount();
            pendingAmount += savedTransactionItem.getPendingAmount();
            totalPrice += savedTransactionItem.getTotalAmount();
        }

        responseDto.setTransactionItems(transactionItemsDto);
        responseDto.setPaidAmount(paidAmount);
        responseDto.setPendingAmount(pendingAmount);
        responseDto.setTotalPrice(totalPrice);
        return responseDto;
    }
}
