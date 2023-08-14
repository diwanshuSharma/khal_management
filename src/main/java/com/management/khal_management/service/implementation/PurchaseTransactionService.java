package com.management.khal_management.service.implementation;

import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionRequestDto;
import com.management.khal_management.dtos.purchase_transaction.PurchaseTransactionResponseDto;
import com.management.khal_management.model.ItemModel;
import com.management.khal_management.model.PurchaseTransactionModel;
import com.management.khal_management.model.SupplierModel;
import com.management.khal_management.model.UnitModel;
import com.management.khal_management.repository.IItemRepository;
import com.management.khal_management.repository.IPurchaseTransactionRepository;
import com.management.khal_management.repository.ISupplierRepository;
import com.management.khal_management.repository.IUnitRepository;
import com.management.khal_management.service.contract.IPurchaseTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseTransactionService implements IPurchaseTransactionService {

    private final IPurchaseTransactionRepository purchaseTransactionRepository;
    private final ISupplierRepository supplierRepository;
    private final IItemRepository itemRepository;
    private final IUnitRepository unitRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PurchaseTransactionService(IPurchaseTransactionRepository purchaseTransactionRepository,
                                      ISupplierRepository supplierRepository,
                                      IItemRepository itemRepository,
                                      IUnitRepository unitRepository,
                                      ModelMapper modelMapper) {
        this.purchaseTransactionRepository = purchaseTransactionRepository;
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
        this.unitRepository = unitRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PurchaseTransactionResponseDto createPurchaseTransaction(PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException {
        SupplierModel supplierModel = supplierRepository.findById(requestDto.getSupplierId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        ItemModel itemModel = itemRepository.findById(requestDto.getItemId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        UnitModel unitModel = unitRepository.findById(requestDto.getUnitId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        PurchaseTransactionModel purchaseTransactionModel = modelMapper.map(requestDto, PurchaseTransactionModel.class);
        purchaseTransactionModel.setSupplier(supplierModel);
        purchaseTransactionModel.setItem(itemModel);
        purchaseTransactionModel.setUnit(unitModel);

        PurchaseTransactionModel createdTransaction = purchaseTransactionRepository.save(purchaseTransactionModel);
        return modelMapper.map(createdTransaction, PurchaseTransactionResponseDto.class);
    }

    @Override
    public PurchaseTransactionResponseDto getPurchaseTransactionById(Long id) throws ChangeSetPersister.NotFoundException {
        PurchaseTransactionModel purchaseTransactionModel = purchaseTransactionRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return modelMapper.map(purchaseTransactionModel, PurchaseTransactionResponseDto.class);
    }

    @Override
    public List<PurchaseTransactionResponseDto> getAllPurchaseTransactions() {
        List<PurchaseTransactionModel> transactions = purchaseTransactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> modelMapper.map(transaction, PurchaseTransactionResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseTransactionResponseDto updatePurchaseTransaction(Long id, PurchaseTransactionRequestDto requestDto) throws ChangeSetPersister.NotFoundException {
        PurchaseTransactionModel purchaseTransactionToUpdate = purchaseTransactionRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        SupplierModel supplierModel = supplierRepository.findById(requestDto.getSupplierId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        ItemModel itemModel = itemRepository.findById(requestDto.getItemId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        UnitModel unitModel = unitRepository.findById(requestDto.getUnitId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        modelMapper.map(requestDto, purchaseTransactionToUpdate);
        purchaseTransactionToUpdate.setSupplier(supplierModel);
        purchaseTransactionToUpdate.setItem(itemModel);
        purchaseTransactionToUpdate.setUnit(unitModel);

        PurchaseTransactionModel updatedTransaction = purchaseTransactionRepository.save(purchaseTransactionToUpdate);
        return modelMapper.map(updatedTransaction, PurchaseTransactionResponseDto.class);
    }

    @Override
    public void deletePurchaseTransaction(Long id) {
        purchaseTransactionRepository.deleteById(id);
    }
}

