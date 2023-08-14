package com.management.khal_management.service.contract;

public interface ICustomerTransactionSettlement {

    void SettleUpGivenAmount(long customerId, double amount);
}
