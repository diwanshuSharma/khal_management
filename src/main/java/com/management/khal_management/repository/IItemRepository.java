package com.management.khal_management.repository;

import com.management.khal_management.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<ItemModel, Long> {
}
