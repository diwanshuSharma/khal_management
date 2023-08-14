package com.management.khal_management.service.implementation;

import java.util.*;
import com.management.khal_management.model.TransactionItemModel;
import com.management.khal_management.model.TransactionModel;
import com.management.khal_management.repository.ITransactionItemRepository;
import com.management.khal_management.service.contract.ICustomerTransactionSettlement;

public class CustomerTransactionSettlement implements ICustomerTransactionSettlement {

    private final ITransactionItemRepository transactionItemRepository;

    public CustomerTransactionSettlement(ITransactionItemRepository transactionItemRepository){
        this.transactionItemRepository = transactionItemRepository;
    }

    @Override
    public void SettleUpGivenAmount(long customerId, double amount) {

        double pendingAmount = 0;
        double paidAmount = 0;
        //1. retrieve all the transactionItems of given user, order by date time asc
        List<TransactionItemModel> transactionItemModelList = transactionItemRepository.findByTransactionModel_CustomerModel_IdAndPendingAmountGreaterThanOrderByCreatedAtAsc(customerId, 0.0);

        //2. settle up all the transactions possible in asc order or date
        for(TransactionItemModel transactionItemModel : transactionItemModelList){

            pendingAmount = transactionItemModel.getPendingAmount();

            if(pendingAmount <= amount){
                // clear the pending amount
                transactionItemModel.setPendingAmount(0.0);
                // set all the amount as paid for that entry
                transactionItemModel.setPaidAmount(transactionItemModel.getTotalAmount());
                // reduce amount
                amount -= pendingAmount;
            }
            else {
                // reduce the pending amount
                pendingAmount -= amount;
                transactionItemModel.setPendingAmount(pendingAmount);
                // update the paid amount
                paidAmount = transactionItemModel.getTotalAmount() - pendingAmount;
                transactionItemModel.setPaidAmount(paidAmount);
                // reduce amount to 0
                amount = 0;
            }

            if(amount == 0)
                break;
        }

        transactionItemRepository.saveAll(transactionItemModelList);
    }
}
