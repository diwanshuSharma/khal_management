package com.management.khal_management.repository;

import com.management.khal_management.model.TransactionItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionItemRepository extends JpaRepository<TransactionItemModel, Long> {
}
