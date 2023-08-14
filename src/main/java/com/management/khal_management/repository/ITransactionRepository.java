package com.management.khal_management.repository;

import com.management.khal_management.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionModel, Long> {
    List<TransactionModel> getAllTransactionsForCustomer(Long customerId);
    List<TransactionModel> findByCustomerModel_IdOrderByCreatedAtAsc(Long customerId);
    List<TransactionModel> findByCustomerModel_IdOrderByCreatedAtDesc(Long customerId);
}
