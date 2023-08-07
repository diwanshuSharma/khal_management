package com.management.khal_management.repository;

import com.management.khal_management.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionModel, Long> {
}
