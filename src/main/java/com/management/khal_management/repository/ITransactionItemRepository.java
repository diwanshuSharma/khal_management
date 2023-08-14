package com.management.khal_management.repository;

import com.management.khal_management.model.TransactionItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionItemRepository extends JpaRepository<TransactionItemModel, Long> {
    List<TransactionItemModel> findByTransactionModel_CustomerModel_IdOrderByCreatedAtAsc(Long customerId);
    List<TransactionItemModel> findByTransactionModel_CustomerModel_IdAndPendingAmountGreaterThanOrderByCreatedAtAsc(Long customerId, Double pendingAmount);
}
