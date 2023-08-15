package com.management.khal_management.service.contract;

public interface ICustomerTransactionSettlementService {

    void SettleUpGivenAmount(long customerId, double amount);
}
