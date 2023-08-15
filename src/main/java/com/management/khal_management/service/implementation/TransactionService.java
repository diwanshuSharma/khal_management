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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //transaction = transactionRepository.save(transaction);

        // Populate and save TransactionItemModel instances
        List<TransactionItemModel> transactionItems = new ArrayList<>();
        for (ItemQuantityRequestDto itemDto : requestDto.getItems()) {
            ItemModel item = itemRepository.findById(itemDto.getItem_id()).get();
            ItemPriceModel itemPrice = itemPriceRepository.findTopByItemModelIdOrderByCreatedAtDesc(item.getId());

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
            transactionItem.setTransactionModel(transaction);

            transactionItems.add(transactionItem);

            totalPrice += itemLevelTotal;
        }

        transaction.setTotalPrice(totalPrice);


        // Save the transaction and its items
        List<TransactionItemModel> savedTransaction = transactionItemRepository.saveAll(transactionItems);
        //transactionRepository.save(transaction);

        // Convert savedTransaction to TransactionResponseDto
        List<TransactionResponseDto> responseList = getTransactionResponseDto(savedTransaction);

        return responseList.get(0);

    }

    private List<TransactionResponseDto> getTransactionResponseDto(List<TransactionItemModel> savedTransaction) {
        double pendingAmount;
        double paidAmount;
        double totalPrice;
        Long transactionId = null;

        TransactionResponseDto responseDto = null;
        List<TransactionItemResponseDto> transactionItemsDto = null;
        TransactionItemResponseDto transactionItemResponseDto = null;

        HashMap<Long, TransactionResponseDto> map = new HashMap<>();

        for(TransactionItemModel savedTransactionItem : savedTransaction){

            //1. transaction id is there in map - no
            // create entry in map for respective DTO object
            transactionId = savedTransactionItem.getTransactionModel().getId();
            if(!map.containsKey(transactionId)){
                responseDto = new TransactionResponseDto();
                transactionItemsDto = new ArrayList<>();
                responseDto.setTransactionItems(transactionItemsDto);
                responseDto.setId(savedTransactionItem.getTransactionModel().getId());
                responseDto.setCreatedAt(savedTransactionItem.getTransactionModel().getCreatedAt());
                responseDto.setUpdatedAt(savedTransactionItem.getTransactionModel().getUpdatedAt());
                map.put(transactionId, responseDto);
            }
            //2. exists in map
                responseDto = map.get(transactionId);
                transactionItemsDto = responseDto.getTransactionItems();
                transactionItemResponseDto = modelMapper.map(savedTransactionItem, TransactionItemResponseDto.class);
                transactionItemsDto.add(transactionItemResponseDto);


                paidAmount = responseDto.getPaidAmount();
                pendingAmount = responseDto.getPendingAmount();
                totalPrice = responseDto.getTotalPrice();

                paidAmount += savedTransactionItem.getPaidAmount();
                pendingAmount += savedTransactionItem.getPendingAmount();
                totalPrice += savedTransactionItem.getTotalAmount();

                responseDto.setPaidAmount(paidAmount);
                responseDto.setPendingAmount(pendingAmount);
                responseDto.setTotalPrice(totalPrice);
        }

        List<TransactionResponseDto> responseList = new ArrayList<>();

        for(Map.Entry<Long, TransactionResponseDto> e : map.entrySet()){
            responseList.add(e.getValue());
        }

        return responseList;
    }

    @Override
    public List<TransactionResponseDto> getAllTransactionsForCustomerHavingPendingAmount(Long customer_id){
        List<TransactionItemModel> transactionItemModels = transactionItemRepository.findByTransactionModel_CustomerModel_IdAndPendingAmountGreaterThanOrderByCreatedAtAsc(customer_id, 0.0);
        return getTransactionResponseDto(transactionItemModels);
    }
}
